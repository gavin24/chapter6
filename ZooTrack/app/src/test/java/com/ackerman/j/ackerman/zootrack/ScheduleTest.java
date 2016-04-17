package com.ackerman.j.ackerman.zootrack;

import com.ackerman.j.gavin.zootrack.Domain.Schedule;
import com.ackerman.j.gavin.zootrack.Domain.Show;
import com.ackerman.j.gavin.zootrack.Factory.Impl.ScheduleFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.ShowFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.ScheduleFactory;
import com.ackerman.j.gavin.zootrack.Factory.ShowFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class ScheduleTest  {
    private ScheduleFactory factory;
    private ShowFactory showFactory;
    @Before
    public void setUp() throws Exception{
        factory = ScheduleFactoryImpl.getInstance();
        showFactory = ShowFactoryImpl.getInstance();
    }

    @Test
    public void testScheduleCreation()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        List<Show> show = new ArrayList<Show>();
        Show shows =   showFactory.createShow("a lions Tale",start,startTime);
        show.add(shows);
        Schedule schedule = factory.createSchedule(show , "qwe", "5 hours", "Anna");
        Assert.assertEquals("qwe", schedule.getType());
    }

    @Test
    public void testScheduleCreationUpdate()
    {
        Time startTime = new Time(12,00,00);
        Date start = new Date(2013,10,13);
        List<Show> show = new ArrayList<Show>();
        Show shows =   showFactory.createShow("a lions Tale",start,startTime);
        show.add(shows);
        Schedule schedule = factory.createSchedule(show , "qwe", "5 hours", "Anna");
        Assert.assertEquals("qwe", schedule.getType());

        Schedule upodateSchedule = new Schedule.Builder(schedule.getDuration())
                .copy(schedule)
                .coach("Peter")
                .build();

        Assert.assertEquals("Peter", upodateSchedule.getCoach());

    }
}
