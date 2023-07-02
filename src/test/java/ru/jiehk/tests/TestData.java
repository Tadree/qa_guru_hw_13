package ru.jiehk.tests;

import com.github.javafaker.Faker;
import ru.jiehk.utils.RandomUtils;

import java.util.Map;

public class TestData {

    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"),
            birthDay = randomUtils.getRandomDay(birthYear, birthMonth),
            subjects = faker.options().option("Maths", "Chemistry", "Computer Science", "Commerce", "Economics",
                    "Accounting", "Arts", "Social Studies", "History", "Civics", "Physics", "English"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            pictureName = "test.jpeg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option(mapStateWithCity.keySet().toArray()).toString(),
            city = faker.options().option(mapStateWithCity.get(state));

}
