package ru.jiehk.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.jiehk.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    @DisplayName("Successful registration")
    void formTest() {
        TestData testData = new TestData();
        step("Open students registration form", () -> {
            registrationFormPage.openPage()
                    .closeAds();
        });
        step("Fill students registration form", () -> {
            registrationFormPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setNumber(testData.mobile)
                    .setBirthDate(testData.birthYear, testData.birthMonth, testData.birthDay)
                    .setSubjects(testData.subjects)
                    .setHobby(testData.hobby)
                    .uploadPicture("src/test/resources/" + testData.pictureName)
                    .setAddress(testData.currentAddress)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submitForm();
        });
        step("Verify successful form submit", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResults("Student Email", testData.email)
                    .checkResults("Gender", testData.gender)
                    .checkResults("Mobile", testData.mobile)
                    .checkResults("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                    .checkResults("Subjects", testData.subjects)
                    .checkResults("Hobbies", testData.hobby)
                    .checkResults("Picture", testData.pictureName)
                    .checkResults("Address", testData.currentAddress)
                    .checkResults("State and City", testData.state + " " + testData.city);
        });
    }
}
