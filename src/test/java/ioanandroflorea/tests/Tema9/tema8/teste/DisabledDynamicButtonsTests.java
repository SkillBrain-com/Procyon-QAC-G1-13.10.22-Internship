package ioanandroflorea.tests.Tema9.tema8.teste;

import ioanandroflorea.tests.Tema9.tema8.pageObjects.DisabledDynamicButtonsPage;
import ioanandroflorea.tests.Tema9.tema8.teste.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DisabledDynamicButtonsTests extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void dynamicButtonsTests() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        DisabledDynamicButtonsPage disabledDynamicButtonsPage = new DisabledDynamicButtonsPage(driver);
        disabledDynamicButtonsPage.waitForTheStartButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnStartButton();
        disabledDynamicButtonsPage.waitForOneButtonToBeClickable();
        disabledDynamicButtonsPage.clickOnOneButton();
        disabledDynamicButtonsPage.waitForTheMessageToDisappear();
        disabledDynamicButtonsPage.clickOnSecondButton();
        disabledDynamicButtonsPage.waitForTheMessageToDisappear();
        disabledDynamicButtonsPage.clickOnThirdButton();
        Assert.assertEquals(disabledDynamicButtonsPage.confirmationMessage(), "All Buttons Clicked", "Click Buttons In Order");
    }
}

