package com.ackerman.j.gavin.zootrack.Factory.Impl;

import com.ackerman.j.gavin.zootrack.Domain.Food;
import com.ackerman.j.gavin.zootrack.Factory.FoodFactory;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class FoodFactoryImpl implements FoodFactory {
    private static FoodFactoryImpl factory = null;

    private FoodFactoryImpl(){

    }

    public static FoodFactoryImpl getInstance(){
        if (factory == null)
            factory = new FoodFactoryImpl();

        return factory;
    }
    public Food createFood(Long id,float price,String name, String type)
    {
        Food food = new Food.Builder(id).price(price).name(name).type(type)
                .build();

        return food;
    }
}