package ancaMarian.tests.tema9.tema8.tests;

import ancaMarian.tests.tema9.tema8.pageObjects.DynamicButtonsSimplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicButtonsSimpleTest extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void dynamicButtonsSimplePageTest() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        DynamicButtonsSimplePage dynamicButtonsSimplePage = new DynamicButtonsSimplePage(driver);
        dynamicButtonsSimplePage.waitForStartButtonToBeVisible();
        dynamicButtonsSimplePage.clickOnStartButton();
        dynamicButtonsSimplePage.waitForOneButtonToBeVisible();
        dynamicButtonsSimplePage.clickOnOneButton();
        dynamicButtonsSimplePage.waitForWaitMessageToDisappear();
        dynamicButtonsSimplePage.clickOnTwoButton();
        dynamicButtonsSimplePage.waitForWaitMessageToDisappear();
        dynamicButtonsSimplePage.clickOnThreeButton();
        Assert.assertEquals(dynamicButtonsSimplePage.confirmationMessage(), "All Buttons Clicked", "Not all buttons were clicked.");
    }
}
