package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.tests.tema9.tema8.pageObjects.SimpleDynamicButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDynamicButtonsTest extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void verifyClickOnAllButtons() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        SimpleDynamicButtonsPage simpleDynamicButtonsPage = new SimpleDynamicButtonsPage(driver);
        simpleDynamicButtonsPage.clickOnStartButton();
        simpleDynamicButtonsPage.clickOnOneButton();
        simpleDynamicButtonsPage.clickOnSecondButton();
        simpleDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(simpleDynamicButtonsPage.getCategoryText(),"All Buttons Clicked");
    }
}
