package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubmitButtonComponent {

    public void clickSubmit() {
        $("#submit").click();
    }
}
