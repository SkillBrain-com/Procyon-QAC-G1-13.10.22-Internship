package ancaMarian.tests.tema9.tema8.tests;

import ancaMarian.tests.tema9.tema8.pageObjects.DisabledDynamicButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisabledDynamicButtonsPageTest extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void dynamicButtonsPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisabledDynamicButtonsPage disabledDynamicButtonsPage = new DisabledDynamicButtonsPage(driver);
        disabledDynamicButtonsPage.waitForStartButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnStartButton();
        disabledDynamicButtonsPage.waitForOneButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnOneButton();
        disabledDynamicButtonsPage.waitForWaitMessageToDisappear();
        disabledDynamicButtonsPage.clickOnTwoButton();
        disabledDynamicButtonsPage.waitForWaitMessageToDisappear();
        disabledDynamicButtonsPage.clickOnThreeButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        Assert.assertTrue(disabledDynamicButtonsPage.waitForConfirmationMessageToAppear());
    }
}
