package catalinazoldi.tests.Tema9.Tema8.tests;


import catalinazoldi.tests.Tema9.Tema8.pageObjects.DynamicButtonsDisabledPage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DynamicButtonsDisabledTest extends BaseTest {

    @Test(groups = {"desktop", "mobile"})
    public void DynamicButtonsDisabledPage() {
        DynamicButtonsDisabledPage dynamicButtonsDisabledPage = new DynamicButtonsDisabledPage(driver);
        dynamicButtonsDisabledPage.goToPage();
        dynamicButtonsDisabledPage.clickButtons();
        assertEquals(dynamicButtonsDisabledPage.getButtonMessage(),"All Buttons Clicked");
    }
}
