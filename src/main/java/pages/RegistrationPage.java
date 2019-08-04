package pages;


import annotations.FieldName;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.tsum.ru/registration/")
public class RegistrationPage extends BasePageObject {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FieldName(name = "Авторизация")
    @FindBy(xpath = "//p[contains (text(), 'Авторизация')]")
    public WebElement authButton;

    @FieldName(name = "Email")
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailField;

    @FieldName(name = "Пароль")
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    public WebElement passwordField;

    @FieldName(name = "Зарегистрироваться")
    @FindBy(xpath = "//div[@class='button-wrapper']/button")
    public WebElement registrationButton;

    @FieldName(name = "Правила продажи товаров")
    @FindBy(className = "//a[text()='Правила продажи товаров']")
    public WebElement rulesLink;

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
        return getField(name, "pages.RegistrationPage");
    }

}
