package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponentUpdate {

    SelenideElement
            stateDropdown = $("#stateCity-wrapper"),
            cityDropdown = $("#stateCity-wrapper");

    // Outer map to store state-city options
    private static Map<String, Map<String, String[]>> stateCityOptions = new HashMap<>();

    public void populateStateCityOptions() {
        // Options for NCR
        Map<String, String[]> ncrOptions = new HashMap<>();
        ncrOptions.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});

        // Options for Uttar Pradesh
        Map<String, String[]> uttarPradeshOptions = new HashMap<>();
        uttarPradeshOptions.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});

        // Options for Haryana
        Map<String, String[]> haryanaOptions = new HashMap<>();
        haryanaOptions.put("Haryana", new String[]{"Karnal", "Panipat"});

        // Options for Rajasthan
        Map<String, String[]> rajasthanOptions = new HashMap<>();
        rajasthanOptions.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        // Populate the outer map
        stateCityOptions.put("NCR", ncrOptions);
        stateCityOptions.put("Uttar Pradesh", uttarPradeshOptions);
        stateCityOptions.put("Haryana", haryanaOptions);
        stateCityOptions.put("Rajasthan", rajasthanOptions);
    }

    public void setStateCity(String state, String city) {

        // Get the city options based on the selected state
        Map<String, String[]> cityOptions = stateCityOptions.get(state);

        $("#state").click();
        stateDropdown.$(byText(state));
        $("#city").click();
        cityDropdown.$(byText(city)).click();
    }
}
