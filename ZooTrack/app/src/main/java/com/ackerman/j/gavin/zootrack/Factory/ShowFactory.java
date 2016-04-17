package com.ackerman.j.gavin.zootrack.Factory;

import com.ackerman.j.gavin.zootrack.Domain.Show;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public interface ShowFactory {

    Show createShow(String name, Date showDay, Time showTime);
}
