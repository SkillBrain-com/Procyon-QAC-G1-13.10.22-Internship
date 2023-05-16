package catalinazoldi.tests.Tema9.Tema8.tests;

import catalinazoldi.tests.Tema9.Tema8.pageObjects.RedirectPage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectTest extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void javaScriptRedirectIn5SecondsPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        RedirectPage javaScriptRedirectPage = new RedirectPage(driver);
        javaScriptRedirectPage.clickOnRedirectIn5SecondsButton();
        javaScriptRedirectPage.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }

    @Test(groups = {"mobile", "desktop"})
    public void javaScriptRedirectIn2SecondsPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        RedirectPage javaScriptRedirectPage = new RedirectPage(driver);
        javaScriptRedirectPage.clickOnRedirectIn2SecondsButton();
        javaScriptRedirectPage.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }
}
