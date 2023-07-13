package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.demoqa.utils.RandomUtils.*;

public class TextBoxWithTestDataTests extends TestBase {

    String fullName = getRandomFirstName(),
            userEmail = getRandomEmailAddress(),
            currentAddress = getRandomAddress(),
            permanentAddress = getRandomAddress();

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxTest() {
        // Fill out the fields
        textBoxPage.openPage()
                .removeBannersFooter()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        // Verify the results after clicking Submit
        textBoxPage.scrollIntoView()
                .verifyOutput("Name:", fullName)
                .verifyOutput("Email:", userEmail)
                .verifyOutput("Current Address:", currentAddress)
                .verifyOutput("Permanent Address:", permanentAddress);

        sleep(10000);
    }
}
