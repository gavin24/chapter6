package com.ackerman.j.gavin.zootrack.FactoryTests;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Factory.AnimalFactory;
import com.ackerman.j.gavin.zootrack.Factory.FoodFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.AnimalFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.FoodFactoryImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class AnimalTest extends TestCase {
    private AnimalFactory factory;
    private FoodFactory foodFactory;


    public void setUp() throws Exception{
        factory = AnimalFactoryImpl.getInstance();
        foodFactory = FoodFactoryImpl.getInstance();
    }

    @Test
    public void testAnimalCreation()
    {
        Date start = new Date(2013,10,13);
        Food food = foodFactory.createFood((long)12,50,"steak","meat");
        Animal animal = factory.createAnimal((long) 2323, "Borris", "Mammal", 23,"Russia",food);
        Assert.assertEquals("Borris", animal.getName());
    }

    @Test
    public void testAnimalCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Food food = foodFactory.createFood((long)12,50,"steak","meat");
        Animal animal = factory.createAnimal((long) 2323, "Borris", "Mammal", 23,"Russia",food);
        Assert.assertEquals("Borris", animal.getName());

        Animal upodateAnimal = new Animal.Builder(animal.getId())
                .copy(animal)
                .Country("China")
                .build();

        Assert.assertEquals("China", upodateAnimal.getCountry());

    }
}
