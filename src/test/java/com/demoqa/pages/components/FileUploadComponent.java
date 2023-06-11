package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadComponent {

    public void uploadFile(String image) {
        $("#uploadPicture").uploadFromClasspath(image);
    }
}
