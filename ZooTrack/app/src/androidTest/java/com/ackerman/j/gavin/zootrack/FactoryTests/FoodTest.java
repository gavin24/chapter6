package com.ackerman.j.gavin.zootrack.FactoryTests;

import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Factory.FoodFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.FoodFactoryImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class FoodTest extends TestCase {
    private FoodFactory factory;


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
