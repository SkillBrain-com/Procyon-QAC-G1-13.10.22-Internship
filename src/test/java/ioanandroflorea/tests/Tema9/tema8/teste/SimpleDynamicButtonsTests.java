package ioanandroflorea.tests.Tema9.tema8.teste;

import ioanandroflorea.tests.Tema9.tema8.teste.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ioanandroflorea.tests.Tema8.pageObjects.BasicAjaxConfirmationPage;
import ioanandroflorea.tests.Tema8.pageObjects.BasicAjaxPage;
import ioanandroflorea.tests.Tema9.tema8.pageObjects.SimpleDynamicButtonsPage;

public class SimpleDynamicButtonsTests extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void verifyClickOnAllButtons() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        SimpleDynamicButtonsPage simpleDynamicButtonsPage = new SimpleDynamicButtonsPage(driver);
        simpleDynamicButtonsPage.clickOnStartButton();
        simpleDynamicButtonsPage.clickOnOneButton();
        simpleDynamicButtonsPage.clickOnSecondButton();
        simpleDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(simpleDynamicButtonsPage.confirmationMessage(), "All Buttons Clicked", "Not all buttons were clicekd.");
    }
}

