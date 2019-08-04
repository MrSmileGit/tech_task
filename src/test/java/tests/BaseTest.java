package tests;

import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Managed
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver.manage().window().maximize();
    }

}
