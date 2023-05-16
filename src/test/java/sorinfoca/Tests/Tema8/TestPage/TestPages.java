package sorinfoca.Tests.Tema8.TestPage;

import sorinfoca.Tests.Tema8.pages.*;
import org.testng.annotations.Test;
import sorinfoca.Tests.Tema8.pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestPages extends BaseTest {

    @Test(groups = {"desktop", "mobile"})
    public void testBasicAjaxPage() {
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.goToPage();
        basicAjaxPage.selectOption("Server");
        basicAjaxPage.selectLanguage("Java");
        basicAjaxPage.clickCodeItInButton();
        assertEquals(basicAjaxPage.getSelectedOption(),"23");
    }

    @Test(groups = {"desktop", "mobile"})
    public void javascriptRedirectPage() {
        JavaScriptRedirectPage javascriptRedirectPage = new JavaScriptRedirectPage(driver);
        javascriptRedirectPage.goToPage();
        javascriptRedirectPage.clickRedirectButton();
        javascriptRedirectPage.waitForRedirect();
        assertEquals("Redirected Landing Page", driver.getTitle());
        driver.navigate().back();
    }

    @Test(groups = {"desktop", "mobile"})
    public void refreshPage() {
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.goToPage();
        String initialTimestamp = refreshPage.getInitialTimestamp();
        driver.navigate().refresh();
        String refreshedTimestamp = refreshPage.getInitialTimestamp();
        assertNotEquals(initialTimestamp, refreshedTimestamp, "Timestamp did not change after refreshing the page");
    }


    @Test(groups = {"desktop", "mobile"})
    public void dynamicButtonsSimplePage() {
        DynamicButtonsSimplePage dynamicButtonsSimplePage = new DynamicButtonsSimplePage(driver);
        dynamicButtonsSimplePage.goToPage();
        dynamicButtonsSimplePage.selectAllButtons();
        assertEquals(dynamicButtonsSimplePage.getSelectedOptions(),"All Buttons Clicked");
    }

    @Test(groups = {"desktop", "mobile"})
    public void dynamicButtonsDisabledPage() {
        DynamicButtonsDisabledPage dynamicButtonsDisabledPage = new DynamicButtonsDisabledPage(driver);
        dynamicButtonsDisabledPage.goToPage();
        dynamicButtonsDisabledPage.clickButtons();
        assertEquals(dynamicButtonsDisabledPage.getButtonMessage(),"All Buttons Clicked");
    }
}

