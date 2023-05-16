package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.tests.tema9.tema8.pageObjects.DisabledDynamicButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledDynamicButtonsTest extends BaseTest {
    @Test(groups = {"mobile", "desktop"})
    public void verifyClickButtonsInOrder() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisabledDynamicButtonsPage disabledDynamicButtonsPage = new DisabledDynamicButtonsPage(driver);
        disabledDynamicButtonsPage.setStartButton();
        disabledDynamicButtonsPage.clickStartButton();
        disabledDynamicButtonsPage.clickOnOneButton();
        disabledDynamicButtonsPage.clickOnSecondButton();
        disabledDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(disabledDynamicButtonsPage.messageDisplay(), "All Buttons Clicked");
    }
}

