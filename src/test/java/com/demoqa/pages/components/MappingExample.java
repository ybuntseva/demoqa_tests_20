package com.demoqa.pages.components;

import org.junit.jupiter.api.Disabled;

import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class MappingExample {
    static Faker faker = new Faker();
    public static Map<String, String[]> statesAndCities = Map.ofEntries(
            Map.entry("NCR", new String[]{"Delhi", "Gurgaon", "Noida"}),
            Map.entry("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"}),
            Map.entry("Haryana", new String[]{"Karnal", "Panipat"}),
            Map.entry("Rajasthan", new String[]{"Jaipur", "Jaiselmer"})
    );

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = faker.number().digits(10),
            dayOfBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1901, 2020)),
            uploadPicture = "corgi.jpg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option(statesAndCities.keySet().toArray(new String[0])),
            city = faker.options().option(statesAndCities.get(state));

    public static String[] subjects = itemsRandom(new String[]{"Biology", "Math", "Chemistry", "Arts"}),
            hobbies = itemsRandom(new String[]{"Sports", "Reading", "Music"});

    public static Map<String, String[]> resultData = Map.ofEntries(
            Map.entry("Student Name", new String[]{firstName + " " + lastName}),
            Map.entry("Student Email", new String[]{email}),
            Map.entry("Gender", new String[]{gender}),
            Map.entry("Mobile", new String[]{number}),
            Map.entry("Date of Birth", new String[]{dayOfBirth + " " + monthOfBirth + "," + yearOfBirth}),
            Map.entry("Subjects", subjects),
            Map.entry("Hobbies", hobbies),
            Map.entry("Picture", new String[]{uploadPicture}),
            Map.entry("Address", new String[]{currentAddress}),
            Map.entry("State and City", new String[]{state + " " + city})
    );

    public static String[] itemsRandom(String[] values) {
        int countOfItems = faker.number().numberBetween(1, 3);
        String[] items = new String[countOfItems];
        Set<String> setOfItems = new HashSet<>();

        for (int i = 0; i < items.length; i++) {
            String randomItem = faker.options().option(values);

            while (setOfItems.contains(randomItem))
                randomItem = faker.options().option(values);

            items[i] = randomItem;
            setOfItems.add(randomItem);
        }
        return items;
    }
}