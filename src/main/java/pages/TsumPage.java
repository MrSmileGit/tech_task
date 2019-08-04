package pages;

import annotations.FieldName;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.tsum.ru")
public class TsumPage extends BasePageObject {

    public TsumPage(WebDriver driver) {
        super(driver);
    }

    @FieldName(name = "Личный кабинет")
    @FindBy(xpath = "//a[@href='/login/']")
    public WebElement personalAccountLink;

    @Override
    public WebElement getField(String name) {
        return getField(name, "pages.TsumPage");
    }

}
