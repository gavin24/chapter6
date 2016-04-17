package com.ackerman.j.ackerman.zootrack;

import com.ackerman.j.gavin.zootrack.Domain.Enclosure;
import com.ackerman.j.gavin.zootrack.Domain.Show;
import com.ackerman.j.gavin.zootrack.Factory.EnclosureFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.EnclosureFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.ShowFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.ShowFactory;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;



import com.ackerman.j.gavin.zootrack.Domain.Enclosure;
import com.ackerman.j.gavin.zootrack.Domain.Show;
import com.ackerman.j.gavin.zootrack.Factory.EnclosureFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.EnclosureFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.ShowFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.ShowFactory;

import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class EnclosureTest  {
    private EnclosureFactory factory;
    private ShowFactory showFactory;
    @Before
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

