package com.ackerman.j.gavin.zootrack.Factory.Impl;

import com.ackerman.j.gavin.zootrack.Domain.Show;
import com.ackerman.j.gavin.zootrack.Factory.ShowFactory;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class ShowFactoryImpl implements ShowFactory {
    private static ShowFactoryImpl factory = null;

    private ShowFactoryImpl(){

    }

    public static ShowFactoryImpl getInstance(){
        if (factory == null)
            factory = new ShowFactoryImpl();

        return factory;
    }
    public Show createShow(String name, Date showDay, Time showTime)
    {
        Show show = new Show.Builder(name).day(showDay).time(showTime)
                .build();

        return show;
    }
}