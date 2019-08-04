package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TsumPage;
import steps.ScenarioSteps;

import static config.ConfigReader.getProperty;

@RunWith(SerenityRunner.class)
public class AuthTest extends BaseTest {

    @Steps
    ScenarioSteps scenarioSteps;

    TsumPage tsumPage;

    @Test
    @Title("Проверка входа зарегистрированного пользователя")
    public void checkInputOfRegisteredUser() {
        tsumPage.open();

        scenarioSteps.stepPageLoaded("TsumPage");
        scenarioSteps.click("Личный кабинет");

        scenarioSteps.stepPageLoaded("LoginPage");
        scenarioSteps.fillField("Email", getProperty("user.email"));
        scenarioSteps.fillField("Пароль", getProperty("user.password"));
        scenarioSteps.rememberValue("Email", "email");
        scenarioSteps.click("Войти");

        scenarioSteps.stepPageLoaded("PersonalProfilePage");
        scenarioSteps.checkFieldForVariable("UserEmail", "email");
    }

    @Test
    @Title("Проверка входа пользователя, который не зарегистрирован в системе")
    public void checkInputOfUnregisteredUser() {
        tsumPage.open();

        scenarioSteps.stepPageLoaded("TsumPage");
        scenarioSteps.click("Личный кабинет");

        scenarioSteps.stepPageLoaded("LoginPage");
        scenarioSteps.fillField("Email", getProperty("user.unregistered.email"));
        scenarioSteps.fillField("Пароль", getProperty("user.password"));
        scenarioSteps.click("Войти");

        scenarioSteps.checkNotification("Неверный логин или пароль");
    }

}
