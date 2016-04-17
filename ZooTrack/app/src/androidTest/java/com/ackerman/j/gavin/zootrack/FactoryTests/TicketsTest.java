package com.ackerman.j.gavin.zootrack.FactoryTests;

import com.ackerman.j.gavin.zootrack.Domain.Tickets;
import com.ackerman.j.gavin.zootrack.Factory.Impl.TicketsFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.TicketsFactory;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class TicketsTest extends TestCase {
    private TicketsFactory factory;


    public void setUp() throws Exception{
        factory = TicketsFactoryImpl.getInstance();
    }

    @Test
    public void testTicketsCreation()
    {
        Date start = new Date(2013,10,13);
        Tickets ticket = factory.createTickets((long)2323, 5000,start,"Adult");
        Assert.assertEquals("Adult", ticket.getType());
    }

    @Test
    public void testTicketsCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Tickets ticket = factory.createTickets((long)2323, 5000,start,"Adult");
        Assert.assertEquals("Adult", ticket.getType());

        Tickets upodateTickets = new Tickets.Builder(ticket.getId())
                .copy(ticket)
                .price(3000)
                .build();

        Assert.assertEquals((float)3000, upodateTickets.getPrice());

    }
}
