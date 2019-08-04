package pages;

import annotations.FieldName;
import net.serenitybdd.core.pages.PageObject;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public abstract class BasePageObject extends PageObject {

    Logger logger = Logger.getLogger(BasePageObject.class);

    public BasePageObject(WebDriver driver) { super(driver); }

    public void fillField(String name, String value) {
        WebElement element = getField(name);
        element.clear();
        fillField(element, value);
    }

    public void click(String name) {
        WebElement element = getField(name);
        click(element);
    }

    public void waitTitle(String title) {
        WebDriverWait driverWait = new WebDriverWait(getDriver(), 15);
        driverWait.until(ExpectedConditions.titleContains(title));
    }

    public abstract WebElement getField(String name) ;

    WebElement getField(String name, String className) {
        try {
            Class example = Class.forName(className);
            List<Field> fields = Arrays.asList(example.getFields());
            for (Field field : fields) {
                if (field.getAnnotation(FieldName.class).name().equals(name)) {
                    return (WebElement) field.get(this);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            Arrays.asList(e.getStackTrace()).forEach(stack -> logger.error(stack));
        }
        Assert.fail("Not declared item with the name: " + name);
        return null;
    }

    private void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
        field.sendKeys(Keys.TAB);
    }

    public void fillFieldEnter(String name, String value) {
        WebElement element = getField(name);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void fillFieldDown(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
        field.sendKeys(Keys.DOWN);
    }


    public void click(WebElement element) {
        element.click();
    }

    public WebElement getNotification(String value) {
        return getDriver().findElement(By.xpath(String.format("//div[contains(@class, 'notice') and contains(text(), '%s')]", value)));
    }

}
