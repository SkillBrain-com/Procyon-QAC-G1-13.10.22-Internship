package bogdanSandu.tests.tema8.tests;

import bogdanSandu.tests.tema8.pageObjects.DynamicButtonsDisabledPage;
import org.testng.annotations.Test;

public class DynamicButtonsDisabledPageTest extends BaseTest {

    @Test(groups = "Desktop")
    public void dynamicButtonDisabledTestForDesktop(){
        System.out.println("Dynamic button disabled test Desktop");
        DynamicButtonsDisabledPage dynamicButtonsDisabledPage = new DynamicButtonsDisabledPage(driver);
        dynamicButtonsDisabledPage.goToPage();
        System.out.println("Got to 'Disabled Dynamic Buttons' link");
        dynamicButtonsDisabledPage.clickButtons();
        dynamicButtonsDisabledPage.getButtonMessage();
    }

    @Test(groups = "Mobile")
    public void dynamicButtonDisabledTestForMobile(){
        System.out.println("Dynamic button disabled test Mobile");
        DynamicButtonsDisabledPage dynamicButtonsDisabledPage = new DynamicButtonsDisabledPage(driver);
        dynamicButtonsDisabledPage.goToPage();
        System.out.println("Got to 'Disabled Dynamic Buttons' link");
        dynamicButtonsDisabledPage.clickButtons();
        dynamicButtonsDisabledPage.getButtonMessage();
    }
}
