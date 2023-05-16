package bogdanSandu.tests.tema9.tema8.tests;

import bogdanSandu.tests.tema9.tema8.pageObjects.DynamicButtonsSimplePage;
import org.testng.annotations.Test;

public class DynamicButtonsSimplePageTest extends BaseTest {

    @Test(groups = "Desktop")
    public void dynamicButtonsTestForDesktop(){
        System.out.println("Dynamic button test Desktop");
        DynamicButtonsSimplePage dynamicButtonsSimplePage = new DynamicButtonsSimplePage(driver);
        dynamicButtonsSimplePage.goToPage();
        System.out.println("Got to 'Simple Dynamic Buttons' link");
        dynamicButtonsSimplePage.clickButtons();
        dynamicButtonsSimplePage.getButtonMessage();
    }

    @Test(groups = "Mobile")
    public void dynamicButtonsTestForMobile(){
        System.out.println("Dynamic button test Mobile");
        DynamicButtonsSimplePage dynamicButtonsSimplePage = new DynamicButtonsSimplePage(driver);
        dynamicButtonsSimplePage.goToPage();
        System.out.println("Got to 'Simple Dynamic Buttons' link");
        dynamicButtonsSimplePage.clickButtons();
        dynamicButtonsSimplePage.getButtonMessage();
    }
}
