package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           userEmail = faker.internet().emailAddress(),
           userGender = "Male",
           userNumber = faker.number().digits(10),
           birthDay = "30",
           birthMonth = "October",
           birthYear = "1999",
           subject = "Math",
           hobbies = "Sports",
           pictureName = "1.png",
           userCurrentAddress = faker.address().fullAddress(),
           state = "NCR",
           city = "Delhi",
           fullName = firstName +" " + lastName,
           dateOfBirth = String.format("%s %s,%s", birthDay, birthMonth, birthYear),
           stateCity = state + " " + city;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(userEmail)
                            .setGender(userGender)
                            .setUserNumber(userNumber)
                            .setBirthDate(birthDay, birthMonth, birthYear)
                            .setSubject(subject)
                            .setHobbies(hobbies)
                            .uploadPicture("img/" + pictureName)
                            .setCurrentAddress(userCurrentAddress)
                            .setState(state)
                            .setCity(city)
                            .submit()
                            .checkResult("Student Name", fullName)
                            .checkResult("Student Email", userEmail)
                            .checkResult("Gender", userGender)
                            .checkResult("Mobile", userNumber)
                            .checkResult("Date of Birth", dateOfBirth)
                            .checkResult("Subjects", subject)
                            .checkResult("Hobbies", hobbies)
                            .checkResult("Picture", pictureName)
                            .checkResult("Address", userCurrentAddress)
                            .checkResult("State and City", stateCity)
                            .close();
    }
}

