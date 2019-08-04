package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePageObject;
import tests.BaseTest;
import org.apache.log4j.Logger;
import java.util.Arrays;

public class ScenarioSteps {

    Logger logger = Logger.getLogger(ScenarioSteps.class);
    private static String currentPageName;

    @Step("Загружена страница \"{0}\"")
    public void stepPageLoaded(String pageName) {
        currentPageName = pageName;
        logger.info(String.format("Page loaded: %s", pageName));
    }

    @Step("Переход на страницу \"{0}\" выполнен, элемент \"{1}\" доступен")
    public void stepPage(String pageName, String title) {
        currentPageName = pageName;
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        page.waitTitle(title);
        logger.info(String.format("Transition to the page \"%s\" is executed, the element \"%s\" available", pageName, title));
    }

    @Step("Заполнить поле \"{0}\" значением \"{1}\"")
    public void fillField(String fieldName, String value) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        page.fillField(fieldName, value);
        logger.info(String.format("Fill the field \"%s\" with value \"%s\"", fieldName, value));
    }

    @Step("Заполнить поле \"{0}\" значением \"{1}\" и выполнить поиск")
    public void fillFieldEnter(String fieldName, String value) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        page.fillFieldEnter(fieldName, value);
        logger.info(String.format("Fill the field \"%s\" with value \"%s\" and perform a search", fieldName, value));
    }

    @Step("Нажать на \"{0}\"")
    public void click(String name) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        page.click(name);
        logger.info(String.format("Click on \"%s\"", name));
    }

    @Step("Появилось уведомление \"{0}\"")
    public void checkNotification(String name) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        Assert.assertTrue(page.getNotification(name).isDisplayed());
        logger.info(String.format("Notification \"%s\" appeared", name));
    }

    @Step("Запомнить значение поля \"{0}\" в переменную \"{1}\"")
    public void rememberValue(String field, String variable) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        Serenity.setSessionVariable(variable).to(page.getField(field).getAttribute("value").trim());
        logger.info(String.format("Save value \"%s\" in variable \"%s\"", page.getField(field).getAttribute("value").trim(), variable));
    }

    @Step("Проверить, что поле \"{0}\" заполнено значением \"{1}\"")
    public void checkFieldForValue(String field, String value) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        Assert.assertEquals(page.getField(field).getText().trim(), value);
    }

    @Step("Проверить, что поле \"{0}\" заполнено значением переменной \"{1}\"")
    public void checkFieldForVariable(String field, String variable) {
        BasePageObject page = null;

        try {
            Class example = Class.forName("pages." + currentPageName);
            page = (BasePageObject) example.getConstructor(WebDriver.class).newInstance(BaseTest.driver);
        } catch (Exception e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        Assert.assertEquals(page.getField(field).getText().trim(), Serenity.sessionVariableCalled(variable).toString());
    }

    @Step("Проверка сообщения о регистрации на email")
    public void checkEmail() {
        //TODO
    }

}
