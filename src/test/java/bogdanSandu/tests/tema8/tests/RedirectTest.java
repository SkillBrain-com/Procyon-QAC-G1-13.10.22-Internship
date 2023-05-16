package bogdanSandu.tests.tema8.tests;

import bogdanSandu.tests.tema8.pageObjects.RedirectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class RedirectTest extends BaseTest {

    @Test(groups = "Desktop")
    public void redirectButtonsTestForDesktop() {
        System.out.println("Redirect buttons test Desktop");
        RedirectsPage redirectsPage = new RedirectsPage(driver);
        redirectsPage.goToPage();
        System.out.println("Got to 'JavaScript Redirects' link");
        redirectsPage.clickDelayBasicButton();
        redirectsPage.backButton();
        System.out.println("Click on back button");
        redirectsPage.clickDelayBounceButton();
        System.out.println("Click on delay bounce button");
        redirectsPage.backButton();
        System.out.println("Click on back button");
    }

    @Test(groups = "Mobile")
    public void redirectButtonsTestForMobile() {
        System.out.println("Redirect buttons test Mobile");
        RedirectsPage redirectsPage = new RedirectsPage(driver);
        redirectsPage.goToPage();
        System.out.println("Got to 'JavaScript Redirects' link");
        redirectsPage.clickDelayBasicButton();
        redirectsPage.backButton();
        System.out.println("Click on back button");
        redirectsPage.clickDelayBounceButton();
        System.out.println("Click on delay bounce button");
        redirectsPage.backButton();
        System.out.println("Click on back button");
    }
}
