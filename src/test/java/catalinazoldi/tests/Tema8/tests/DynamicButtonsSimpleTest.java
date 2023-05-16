package catalinazoldi.tests.Tema8.tests;

import catalinazoldi.tests.Tema8.pageObjects.DynamicButtonsSimplePage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DynamicButtonsSimpleTest extends BaseTest {

    @Test(groups = {"desktop", "mobile"})
    public void verifyClickOnAllButtons(){
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        DynamicButtonsSimplePage simpleDynamicButtonPages = new DynamicButtonsSimplePage(driver);
        simpleDynamicButtonPages.clickOnStartButton();
        simpleDynamicButtonPages.clickOnOneButton();
        simpleDynamicButtonPages.clickOnSecondButton();
        simpleDynamicButtonPages.clickOnThreeButton();
        Assert.assertEquals(simpleDynamicButtonPages.displayTextAfterAllButtons(), "All Buttons Clicked");
    }
}

