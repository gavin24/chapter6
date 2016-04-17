package com.ackerman.j.ackerman.zootrack;

import com.ackerman.j.gavin.zootrack.Domain.Animal;
import com.ackerman.j.gavin.zootrack.Domain.Employee;
import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Domain.Staff;
import com.ackerman.j.gavin.zootrack.Factory.AnimalFactory;
import com.ackerman.j.gavin.zootrack.Factory.EmployeeFactory;
import com.ackerman.j.gavin.zootrack.Factory.FoodFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.AnimalFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.EmployeeFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.FoodFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.Impl.StaffFactoryImpl;
import com.ackerman.j.gavin.zootrack.Factory.StaffFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gavin.ackerman on 2016-04-17.
 */
public class AnimalTest {
    private AnimalFactory factory;
    private FoodFactory foodFactory;

    @Before
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
        Animal animal = factory.createAnimal((long) 2323, "Borris", "Mammal", 23, "Russia", food);
        Assert.assertEquals("Borris", animal.getName());

        Animal upodateAnimal = new Animal.Builder(animal.getId())
                .copy(animal)
                .Country("China")
                .build();

        Assert.assertEquals("China", upodateAnimal.getCountry());

    }

    /**
     * Created by gavin.ackerman on 2016-04-15.
     */

    }

