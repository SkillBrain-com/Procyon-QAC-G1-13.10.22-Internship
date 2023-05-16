package elizCurtnazar.tests.tema9.gridtema8.teste;

import elizCurtnazar.tests.tema8.pageObject.SimpleDynamicButtonsPage;
import elizCurtnazar.tests.tema8.teste.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDynamicButtonsTests extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void verifyClickOnAllButtons() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        SimpleDynamicButtonsPage simpleDynamicButtonsPage = new SimpleDynamicButtonsPage(driver);
        Assert.assertEquals(simpleDynamicButtonsPage.getButtonMessage(),"Click all 4 buttons.");
        simpleDynamicButtonsPage.clickOnStartButton();
        Assert.assertEquals(simpleDynamicButtonsPage.getButtonMessage(),"Click all 4 buttons.");
        simpleDynamicButtonsPage.clickOnOneButton();
        Assert.assertEquals(simpleDynamicButtonsPage.getButtonMessage(),"Click all 4 buttons.");
        simpleDynamicButtonsPage.clickOnSecondButton();
        Assert.assertEquals(simpleDynamicButtonsPage.getButtonMessage(),"Click all 4 buttons.");
        simpleDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(simpleDynamicButtonsPage.getButtonMessage(),"All Buttons Clicked");
    }
}
