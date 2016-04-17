package com.ackerman.j.gavin.zootrack.FactoryTests;

import com.ackerman.j.gavin.zootrack.Domain.Show;
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
public class ShowTest extends TestCase {
    private ShowFactory factory;


    public void setUp() throws Exception{
        factory = ShowFactoryImpl.getInstance();
    }

    @Test
    public void testShowCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = factory.createShow("A Lions Tale", start, startTime);
        Assert.assertEquals("A Lions Tale", show.getname());
    }

    @Test
    public void testShowCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        Show show = factory.createShow("A Lions Tale", start, startTime);
        Assert.assertEquals("A Lions Tale", show.getname());
        Date newStart = new Date(2015,10,13);
        Show upodateShow = new Show.Builder(show.getname())
                .copy(show)
                .day(newStart)
                .build();

        Assert.assertEquals(newStart, upodateShow.getDay());

    }
}
