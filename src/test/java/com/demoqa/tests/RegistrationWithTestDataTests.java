package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.demoqa.utils.RandomUtils.*;

public class RegistrationWithTestDataTests extends TestBase {

    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmailAddress(),
            gender = getRandomGender(),
            userNumber = getRandomPhoneNumber(),
            birthMonth = getRandomMonth(),
            birthYear = String.valueOf(getRandomInt(1900, 2023)),
            birthDay = getRandomFakerDay(),
            subject1 = getRandomSubject(),
            subject2 = getRandomFakerSubject(),
            hobby = getRandomHobby(),
            fileName = "Zugpsitze_mountain.jpeg",
            userAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        // Fill out registration form
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby)
                .uploadFile(fileName)
                .setCurrentAddress(userAddress)
                .setStateCity(state, city)
                .clickSubmit();

        // Verify results

        registrationPage.verifyModalWindow()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", subject1 + ", " + subject2)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", fileName)
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", state + " " + city);

        sleep(10000);
    }
}
