package pages;

import annotations.FieldName;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.tsum.ru/login/")
public class LoginPage extends BasePageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FieldName(name = "Регистрация")
    @FindBy(xpath = "//p[contains (text(), 'Регистрация')]")
    public WebElement registrationButton;

    @FieldName(name = "Email")
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailField;

    @FieldName(name = "Пароль")
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    public WebElement passwordField;

    @FieldName(name = "Войти")
    @FindBy(xpath = "//div[@class='button-wrapper']/button")
    public WebElement enterButton;

    @FieldName(name = "Забыли пароль?")
    @FindBy(className = "forget-pwd")
    public WebElement forgetPasswordLink;

    @FieldName(name = "Facebook")
    @FindBy(className = "social-icon facebook-icon")
    public WebElement facebookInput;

    @FieldName(name = "Twitter")
    @FindBy(className = "social-icon twitter-icon")
    public WebElement twitterInput;

    @FieldName(name = "VK")
    @FindBy(className = "social-icon vk-icon")
    public WebElement vkInput;


    @Override
    public WebElement getField(String name) {
        return getField(name, "pages.LoginPage");
    }
}
