package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoqaTest {

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

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

     @Test

    void firstTest() {
         open("/automation-practice-form");
         executeJavaScript("$('#fixedban').remove()");
         executeJavaScript("$('footer').remove()");

         $("#firstName").setValue(firstName);
         $("#lastName").setValue(lastName);
         $("#userEmail").setValue(userEmail);
         $(byText(gender)).click();
         $("#userNumber").setValue(userNumber);

         // Открыть datepicker (выбор даты)
         $("#dateOfBirthInput").click();

         // Выбрать месяц рождения
         $(".react-datepicker__month-select").selectOption(monthOfBirth);

         // Выбрать год рождения
         $(".react-datepicker__year-select").selectOption(yearOfBirth);

         // Кликнуть для перехода на выбор числа
         $(".react-datepicker__month").click();
         $(by("aria-label", "Choose Tuesday, March 13th, 1990")).click();

         $("#subjectsInput").setValue(subject).pressEnter();
         $("#hobbiesWrapper").$(byText(hobby1)).click();
         $("#hobbiesWrapper").$(byText(hobby2)).click();
         $("#uploadPicture").uploadFile(new File("resources/Zugpsitze_mountain.jpeg"));
         $("#currentAddress").setValue(userAddress);

         $("#state").click();
         $("#stateCity-wrapper").$(byText(state)).click();
         $("#city").click();
         $("#stateCity-wrapper").$(byText(city)).click();
         $("#submit").click();

         // Проверить, что введенные данные отображаются в сводной таблице после нажатия кнопки Submit
         $(byText(submitMessage)).shouldBe(Condition.visible);
         $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Helen Smith"));
         $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
         $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
         $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
         $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 March,1990"));
         $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
         $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby1));
         $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby2));
         $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Zugpsitze_mountain.jpeg"));
         $(".table-responsive").$(byText("Address")).parent().shouldHave(text(userAddress));
         $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));
     }
}
