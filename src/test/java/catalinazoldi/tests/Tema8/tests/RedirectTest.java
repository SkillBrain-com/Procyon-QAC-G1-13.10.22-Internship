package catalinazoldi.tests.Tema8.tests;

import ancaMarian.tests.tema8.pageObjects.JavaScriptRedirectPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectTest extends BaseTest{
    @Test(groups = {"mobile", "desktop"})
    public void javaScriptRedirectIn5SecondsPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        JavaScriptRedirectPage javaScriptRedirectPage = new JavaScriptRedirectPage(driver);
        javaScriptRedirectPage.clickOnRedirectIn5SecondsButton();
        javaScriptRedirectPage.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }

    @Test(groups = {"mobile", "desktop"})
    public void javaScriptRedirectIn2SecondsPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        JavaScriptRedirectPage javaScriptRedirectPage = new JavaScriptRedirectPage(driver);
        javaScriptRedirectPage.clickOnRedirectIn2SecondsButton();
        javaScriptRedirectPage.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }
}
