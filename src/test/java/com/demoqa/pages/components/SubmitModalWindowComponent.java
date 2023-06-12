package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitModalWindowComponent {

    SelenideElement
            submitModalWindow = $(".modal-dialog"),
            tableResults = $(".table-responsive");

    public void verifyModalWindow() {
        submitModalWindow.shouldBe(Condition.visible).shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyTableResults(String nameElement, String value) {
        tableResults.find(byText(nameElement)).sibling(0).shouldHave(text(value));
    }
}
