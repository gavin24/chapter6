package com.ackerman.j.ackerman.zootrack;

import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Factory.FoodFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.FoodFactoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Date;



/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class FoodTest {
    private FoodFactory factory;

    @Before
    public void setUp() throws Exception{
        factory = FoodFactoryImpl.getInstance();
    }

    @Test
    public void testFoodCreation()
    {
        Date start = new Date(2013,10,13);
        Food food = factory.createFood((long) 2323, 5000, "steak", "Meat");
        Assert.assertEquals("Meat", food.getType());
    }

    @Test
    public void testFoodCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Food food = factory.createFood((long) 2323, 5000, "steak", "Meat");
        Assert.assertEquals("Meat", food.getType());

        Food upodateFood = new Food.Builder(food.getId())
                .copy(food)
                .name("chicken")
                .build();
        Assert.assertEquals("chicken", upodateFood.getname());

    }
}
