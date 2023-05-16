package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.tests.Tema9.Tema8.pageObjects.DisabledDynamicButtonConfirmationPage;
import alinatinca.tests.Tema9.Tema8.pageObjects.DisabledDynamicButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledDynamicButtonsPageTest extends BaseTest {
    @Test(groups = {"mobile", "desktop"})
    public void clickOnAllButtons() {
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisabledDynamicButtonConfirmationPage disabledDynamicButtonConfirmationPage = new DisabledDynamicButtonConfirmationPage(remoteWebDriver);
        Assert.assertEquals(disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "Click Buttons In Order");
        System.out.println("The message that appears before openening all the buttons is: " + disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons());
        DisabledDynamicButtonsPage disabledDynamicButtonsPage = new DisabledDynamicButtonsPage(remoteWebDriver);
        disabledDynamicButtonsPage.clickOnStartButton();
        disabledDynamicButtonsPage.clickOnOneButton();
        disabledDynamicButtonsPage.clickOnSecondButton();
        disabledDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "All Buttons Clicked");
        System.out.println("The message that appears after opening all the buttons is: " + disabledDynamicButtonConfirmationPage.displayTextForClickAllButtons());
        System.out.println("Check was done successfully!");
    }
}