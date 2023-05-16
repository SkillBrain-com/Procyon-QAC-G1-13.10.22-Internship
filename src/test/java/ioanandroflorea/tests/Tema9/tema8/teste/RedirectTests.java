package ioanandroflorea.tests.Tema9.tema8.teste;

import ioanandroflorea.tests.Tema9.tema8.pageObjects.RedirectPage;
import ioanandroflorea.tests.Tema9.tema8.teste.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectTests extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void RedirectTestIn5Seconds() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        RedirectPage redirectPage = new RedirectPage(driver);
        RedirectPage.clickOnRedirectIn5SecondsButton();
        RedirectPage.waitToRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }
    @Test(groups = {"mobile", "desktop"})
    public void RedirectTestIn2Seconds() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        RedirectPage redirectPage = new RedirectPage(driver);
        RedirectPage.clickOnRedirectIn2SecondsButton();
        RedirectPage.waitToRedirect();
        Assert.assertEquals(driver.getCurrentUrl(), "https://testpages.herokuapp.com/styled/redirected.html");
    }
}

