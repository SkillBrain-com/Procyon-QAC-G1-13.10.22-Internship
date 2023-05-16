package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.tests.Tema9.Tema8.pageObjects.JavaScriptRedirectsConfirmationPage;
import alinatinca.tests.Tema9.Tema8.pageObjects.JavaScriptRedirectsPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptRedirectsPageTests extends BaseTest{
    @Test(groups = {"mobile", "desktop"})
    public void clickOnFirstButton() {
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        WebDriverWait wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        JavaScriptRedirectsPage javaScriptRedirectsPage = new JavaScriptRedirectsPage(remoteWebDriver);
        System.out.println("The message in the paragraph on the first page is: " + javaScriptRedirectsPage.getParagraph());
        javaScriptRedirectsPage.clickOnFirstButton();
        JavaScriptRedirectsConfirmationPage javaScriptRedirectsConfirmationPage = new JavaScriptRedirectsConfirmationPage(remoteWebDriver);
//        Assert.assertEquals(driver.getCurrentUrl(),
//                "https://testpages.herokuapp.com/styled/redirected.html");
        Assert.assertEquals(javaScriptRedirectsConfirmationPage.displayText(), "You have been successfully redirected.");
        System.out.println("The message from the new window has been displayed: " + javaScriptRedirectsConfirmationPage.displayText());
        System.out.println("Check was done successfully!");
        javaScriptRedirectsConfirmationPage.clickOnBackButton();
    }
    @Test(groups = {"mobile", "desktop"})
    public void clickOnSecondButton(){
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        WebDriverWait wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        JavaScriptRedirectsPage javaScriptRedirectsPage = new JavaScriptRedirectsPage(remoteWebDriver);
        System.out.println("The message in the paragraph on the first page is: " + javaScriptRedirectsPage.getParagraph());
        javaScriptRedirectsPage.clickOnSecondButton();
        JavaScriptRedirectsConfirmationPage javaScriptRedirectsConfirmationPage = new JavaScriptRedirectsConfirmationPage(remoteWebDriver);
        Assert.assertEquals(javaScriptRedirectsConfirmationPage.displayText(), "You have been successfully redirected.");
        System.out.println("The message from the new window has been displayed: " + javaScriptRedirectsConfirmationPage.displayText());
        System.out.println("Check was done successfully!");
        javaScriptRedirectsConfirmationPage.clickOnBackButton();
    }
}