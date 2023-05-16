package elizCurtnazar.tests.tema9.gridtema8.teste;

import elizCurtnazar.tests.tema8.pageObject.JavaScriptLandingPage;
import elizCurtnazar.tests.tema8.pageObject.JavaScriptRedirectsPage;
import elizCurtnazar.tests.tema8.teste.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptRedirectsTests extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void clickFirstButton() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        JavaScriptRedirectsPage javaScriptRedirectsPage = new JavaScriptRedirectsPage(driver);
        javaScriptRedirectsPage.getParagraphText();
        javaScriptRedirectsPage.clickFirstButton();
        JavaScriptLandingPage javaScriptLandingPage = new JavaScriptLandingPage(driver);
        Assert.assertEquals(javaScriptLandingPage.getTextofParagraph(), "You have been successfully redirected.");
        javaScriptLandingPage.clickGoBackButton();
    }

    @Test(groups = {"mobile", "desktop"})
    public void clickSecondButton() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        JavaScriptRedirectsPage javaScriptRedirectsPage = new JavaScriptRedirectsPage(driver);
        javaScriptRedirectsPage.getParagraphText();
        javaScriptRedirectsPage.clickSecondButton();
        JavaScriptLandingPage javaScriptLandingPage = new JavaScriptLandingPage(driver);
        Assert.assertEquals(javaScriptLandingPage.getTextofParagraph(), "You have been successfully redirected.");
        javaScriptLandingPage.clickGoBackButton();
    }
}