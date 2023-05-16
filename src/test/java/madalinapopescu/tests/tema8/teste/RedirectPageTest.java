package madalinapopescu.tests.tema8.teste;

import madalinapopescu.tests.tema8.pageobjects.RedirectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RedirectPageTest extends BaseTest {
    @Test(groups = {"mobile", "desktop"})
    public void clickOnFirstButton() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        RedirectPage redirectPage = new RedirectPage(driver);
        redirectPage.clickOnFirstButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://testpages.herokuapp.com/styled/redirected.html");
        redirectPage.clickOnBackButton();
    }

    @Test(groups = {"mobile", "desktop"})
    public void clickOnSecondButton(){
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        RedirectPage redirectPage = new RedirectPage(driver);
        redirectPage.clickOnSecondButton();
        Assert.assertEquals(redirectPage.displayText(), "You have been successfully redirected.");
        redirectPage.clickOnBackButton();
    }
}
