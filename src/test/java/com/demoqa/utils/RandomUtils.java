package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomFirstName() {

        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {

        return new Faker().name().lastName();
    }

    public static String getRandomEmailAddress() {

        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomFakerGender() {
        String[] genders = {"Male", "Female", "Other"};

        return new Faker().options().option(genders);
    }

    public static String getRandomPhoneNumber() {

        return new Faker().phoneNumber().subscriberNumber(10);
    }

//     +3 (263) 253 - 66 - 12
    public static String getRandomPhone() {

        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};

        return getRandomItemFromArray(months);
    }

    public static String getRandomFakerMonth() {
        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};

        return new Faker().options().option(months);
    }

    public static String getRandomFakerDay() {

        return String.format("%02d", new Faker().number().numberBetween(1, 28));
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomFakerHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return new Faker().options().option(hobbies);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomFakerSubject() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics",
                "Commerce", "Computer Science", "Economics", "English", "Hindi",
                "History", "Maths", "Physics", "Social Studies"};

        return new Faker().options().option(subjects);
    }

    public static String getRandomAddress() {

        return new Faker().address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItemFromArray(ncrCities);
        } else if (state.equals("Uttar Pradesh")) {
            String[] uttarPradeshCities = {"Agra", "Lucknow", "Merrut"};
            return getRandomItemFromArray(uttarPradeshCities);
        } else if (state.equals("Haryana")) {
            String[] haryanaCities = {"Karnal", "Panipat"};
            return getRandomItemFromArray(haryanaCities);
        } else if (state.equals("Rajasthan")) {
            String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
            return getRandomItemFromArray(rajasthanCities);
        }
        return null;
    }
}
