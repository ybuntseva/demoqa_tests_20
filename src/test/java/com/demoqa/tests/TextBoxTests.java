package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    String fullName = "Helen Smith",
            userEmail = "j.buntseva@gmail.com",
            currentAddress = "Moscow, Tverskaya Str, 17",
            permanentAddress = "Tula, Lenin Str, 10";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxTest() {
        // Fill out the fields
        textBoxPage.openPage()
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
    }
}
