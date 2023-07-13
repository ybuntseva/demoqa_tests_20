package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.SubmitButtonComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement
            mainHeader = $(".main-header"),
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            outputResults = $("#output");
    SubmitButtonComponent submitButtonComponent = new SubmitButtonComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        mainHeader.shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage removeBannersFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButtonComponent.clickSubmit();

        return this;
    }

    public TextBoxPage verifyOutput(String nameElement, String value) {
        outputResults.find(byText(nameElement)).shouldHave(text(value));

        return this;
    }

    public TextBoxPage scrollIntoView() {
        outputResults.scrollIntoView(true);

        return this;
    }
}
