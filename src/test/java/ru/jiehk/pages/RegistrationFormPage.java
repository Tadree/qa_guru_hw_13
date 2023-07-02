package ru.jiehk.pages;

import com.codeborne.selenide.SelenideElement;
import ru.jiehk.pages.components.Calendar;
import ru.jiehk.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    Calendar calendar = new Calendar();
    ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyRadioButton = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelector = $("#state"),
            stateList = $("#stateCity-wrapper"),
            citySelector = $("#city"),
            cityList = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage closeAds() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String year, String month, String day) {
        dateOfBirthInput.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobbyRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFile(new File(value));
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateSelector.click();
        stateList.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        citySelector.click();
        cityList.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }
}
