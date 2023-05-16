package madalinapopescu.tests.tema8.teste;

import madalinapopescu.tests.tema8.pageobjects.BasicAjaxConfirmationPage;
import madalinapopescu.tests.tema8.pageobjects.BasicAjaxPage;
import madalinapopescu.tests.tema8.pageobjects.SimpleDynamicButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDynamicButtonsTests extends BaseTest{

    @Test(groups = {"mobile", "desktop"})
    public void verifyClickOnAllButtons(){
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        SimpleDynamicButtonPage simpleDynamicButtonPages = new SimpleDynamicButtonPage(driver);
        simpleDynamicButtonPages.clickOnStartButton();
        simpleDynamicButtonPages.clickOnOneButton();
        simpleDynamicButtonPages.clickOnSecondButton();
        simpleDynamicButtonPages.clickOnThertButton();
        Assert.assertEquals(simpleDynamicButtonPages.displayTextAfterAllButtons(), "All Buttons Clicked");
    }
}
