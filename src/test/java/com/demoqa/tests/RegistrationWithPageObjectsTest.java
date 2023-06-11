package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTest extends TestBase {

    String firstName = "Helen";
    String lastName = "Smith";
    String userEmail = "juliabuntseva@gmail.com";
    String gender = "Female";
    String userNumber = "6003319000";
    String yearOfBirth = "1990";
    String monthOfBirth = "March";
    String subject = "Chemistry";
    String hobby1 = "Music";
    String hobby2 = "Reading";
    String userAddress = "Moscow, Tverskaya Street, 21";
    String state = "Uttar Pradesh";
    String city = "Agra";
    String submitMessage = "Thanks for submitting the form";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
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

//        // Проверить, что введенные данные отображаются в сводной таблице после нажатия кнопки Submit
//        $(byText(submitMessage)).shouldBe(Condition.visible);
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Helen Smith"));
//        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
//        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
//        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
//        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 March,1990"));
//        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
//        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby1));
//        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby2));
//        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Zugpsitze_mountain.jpeg"));
//        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(userAddress));
//        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
        sleep(10000);
    }
}
