package com.ackerman.j.gavin.zootrack.FactoryTests;

import com.ackerman.j.gavin.zootrack.Domain.Enclosure;
import com.ackerman.j.gavin.zootrack.Domain.Show;
import com.ackerman.j.gavin.zootrack.Factory.EnclosureFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.EnclosureFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.ShowFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.ShowFactory;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class EnclosureTest extends TestCase {
    private EnclosureFactory factory;
    private ShowFactory showFactory;

    public void setUp() throws Exception{
        factory = EnclosureFactoryImpl.getInstance();
        showFactory = ShowFactoryImpl.getInstance();
    }

    @Test
    public void testEnclosureCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);

        Show show = showFactory.createShow("a lions Tale",start,startTime);
        Enclosure enclosure = factory.createEnclosure("cage", "Lions Den", "James",show );
        Assert.assertEquals("cage", enclosure.getType());
    }

    @Test
    public void testEnclosureCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = showFactory.createShow("a lions Tale",start,startTime);
        Enclosure enclosure = factory.createEnclosure("cage", "Lions Den", "James",show);
        Assert.assertEquals("cage", enclosure.getType());

        Enclosure upodateEnclosure = new Enclosure.Builder(enclosure.getType())
                .copy(enclosure)
                .coach("Peter")
                .build();

        Assert.assertEquals("Peter", upodateEnclosure.getCoach());

    }
}
