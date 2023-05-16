package madalinapopescu.tests.tema8.teste;

import madalinapopescu.tests.tema8.pageobjects.DisabledDynamicButtonPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisabledDynamicButtonPageTest extends BaseTest{
    @Test(groups = {"mobile", "desktop"})
    public void clickOnAllButtons() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        DisabledDynamicButtonPage disabledDynamicButtonPage = new DisabledDynamicButtonPage(driver);
        disabledDynamicButtonPage.clickOnStartButton();
        disabledDynamicButtonPage.clickOnOneButton();
        disabledDynamicButtonPage.clickOnSecondButton();
        disabledDynamicButtonPage.clickOnThirdButton();
        Assert.assertEquals(disabledDynamicButtonPage.textForClickAllButtons(), "All Buttons Clicked");
    }
}
