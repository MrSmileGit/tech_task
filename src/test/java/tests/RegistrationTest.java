package tests;

import helpers.RandomGenerator;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TsumPage;
import steps.ScenarioSteps;

import static config.ConfigReader.getProperty;

@RunWith(SerenityRunner.class)
public class RegistrationTest extends BaseTest {

    @Steps
    ScenarioSteps scenarioSteps;

    TsumPage tsumPage;

    @Test
    @Title("Проверка регистрации с валидным email")
    public void checkRegistrationUser() {
        tsumPage.open();

        scenarioSteps.stepPageLoaded("TsumPage");
        scenarioSteps.click("Личный кабинет");

        scenarioSteps.stepPageLoaded("LoginPage");
        scenarioSteps.click("Регистрация");

        scenarioSteps.stepPageLoaded("RegistrationPage");
        scenarioSteps.fillField("Email", RandomGenerator.getRandomEmail());
        scenarioSteps.fillField("Пароль", getProperty("user.password"));
        scenarioSteps.rememberValue("Email", "email");
        scenarioSteps.click("Зарегистрироваться");

        scenarioSteps.stepPageLoaded("PersonalProfilePage");
        scenarioSteps.checkNotification("Успешная регистрация");
        scenarioSteps.checkFieldForVariable("UserEmail", "email");
        scenarioSteps.checkEmail();
    }

    @Test
    @Title("Проверка невозможности регистрации уже зарегистрированного пользователя")
    public void checkRegistrationOfAlreadyRegisteredUser() {
        tsumPage.open();

        scenarioSteps.stepPageLoaded("TsumPage");
        scenarioSteps.click("Личный кабинет");

        scenarioSteps.stepPageLoaded("LoginPage");
        scenarioSteps.click("Регистрация");

        scenarioSteps.stepPageLoaded("RegistrationPage");
        scenarioSteps.fillField("Email", getProperty("user.email"));
        scenarioSteps.fillField("Пароль", getProperty("user.password"));
        scenarioSteps.click("Зарегистрироваться");

        scenarioSteps.checkNotification("Пользователь с таким email уже существует.");
    }

}
