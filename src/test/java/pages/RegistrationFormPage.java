package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    // Locators
    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateInput = $("#state"),
                    stateCityWrapper = $("#stateCity-wrapper"),
                    cityInput = $("#city"),
                    submitButton = $("#submit"),
                    tableResponsive = $(".table-responsive"),
                    closeButton = $("#closeLargeModal");

    //Actions
    @Step("Открытие страницы")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Имя")
    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Фамилия")
    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Почта")
    public RegistrationFormPage setEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    @Step("Пол")
    public RegistrationFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    @Step("Номер")
    public RegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    @Step("День рождения")
    public RegistrationFormPage setBirthDate(String birthDay, String birthMonth, String birthYear) {
        dateOfBirthInput.click();
        calendarComponent.setData(birthDay, birthMonth, birthYear);

        return this;
    }

    @Step("Предмет")
    public RegistrationFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Хобби")
    public RegistrationFormPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();

        return this;
    }

    @Step("Фото")
    public RegistrationFormPage uploadPicture(String picturePath) {
        uploadPicture.uploadFromClasspath(picturePath);

        return this;
    }

    @Step("Адресс")
    public RegistrationFormPage setCurrentAddress(String userCurrentAddress) {
        currentAddressInput.setValue(userCurrentAddress);

        return this;
    }

    @Step("Страна")
    public RegistrationFormPage setState(String state) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    @Step("Город")
    public RegistrationFormPage setCity(String city) {
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    @Step("Принять")
    public RegistrationFormPage submit() {
        submitButton.click();

        return this;
    }

    @Step("Проверка")
    public RegistrationFormPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    @Step("Закрыть")
    public RegistrationFormPage close() {
        closeButton.click();

        return this;
    }
}
