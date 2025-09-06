package com.worldofsystem.utils;

import com.github.javafaker.Faker;

public class FakerData {

    public static String dynamicId(){
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(2000, 10000));

    }
}
