package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.tests.Tema9.Tema8.pageObjects.SimpleDynamicButtonConfirmationPage;
import alinatinca.tests.Tema9.Tema8.pageObjects.SimpleDynamicButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDynamicButtonsPageTest extends BaseTest{
    @Test(groups = {"mobile", "desktop"})
    public void checkClickOnAllButtons(){
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        SimpleDynamicButtonConfirmationPage simpleDynamicButtonConfirmationPage = new SimpleDynamicButtonConfirmationPage(remoteWebDriver);
        Assert.assertEquals(simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "Click all 4 buttons.");
        System.out.println("The message that appears before openening all the buttons is: " + simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons());
        SimpleDynamicButtonPage simpleDynamicButtonPage = new SimpleDynamicButtonPage(remoteWebDriver);
        simpleDynamicButtonPage.clickOnStartButton();
        simpleDynamicButtonPage.clickOnOneButton();
        simpleDynamicButtonPage.clickOnSecondButton();
        simpleDynamicButtonPage.clickOnThirdButton();
        Assert.assertEquals(simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons(), "All Buttons Clicked");
        System.out.println("The message that appears after opening all the buttons is: " + simpleDynamicButtonConfirmationPage.displayTextForClickAllButtons());
        System.out.println("Check was done successfully!");
    }
}