package pages;

import annotations.FieldName;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.tsum.ru/personal/profile/")
public class PersonalProfilePage extends BasePageObject {

    public PersonalProfilePage(WebDriver driver) {
        super(driver);
    }

    @FieldName(name = "UserEmail")
    @FindBy(xpath = "//a[@rel='nofollow']")
    public WebElement userEmail;


    @Override
    public WebElement getField(String name) {
        return getField(name, "pages.PersonalProfilePage");
    }
}
