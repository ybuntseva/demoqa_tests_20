package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTest extends TestBase {

    String firstName = "Helen";
    String lastName = "Smith";
    String userEmail = "juliabuntseva@gmail.com";
    String gender = "Female";
    String userNumber = "6003319000";
    String subject = "Chemistry";
    String hobby1 = "Music";
    String hobby2 = "Reading";
    String userAddress = "Moscow, Tverskaya Street, 21";
    String state = "Uttar Pradesh";
    String city = "Agra";
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        // Fill out registration form
        registrationPage.openPage()
                .removeBannersFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate("28", "March", "1990")
                .setSubjects(subject)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .uploadFile("Zugpsitze_mountain.jpeg")
                .setCurrentAddress(userAddress)
                .setStateCity(state, city)
                .clickSubmit();

        // Verify results

        registrationPage.verifyModalWindow()
                .verifyResults("Student Name", firstName+" "+lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", "28 March,1990")
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby1+", "+hobby2)
                .verifyResults("Picture", "Zugpsitze_mountain.jpeg")
                .verifyResults("Address", userAddress)
                .verifyResults("State and City", state+" "+city);
    }
}
