package bogdanSandu.tests.tema8.tests;

import bogdanSandu.tests.tema8.pageObjects.BasicAjaxPage;
import org.testng.annotations.Test;

public class BasicAjaxPageTest extends BaseTest {

    @Test(groups = "Desktop")
    public void codeItInTestForDesktop() {
        System.out.println("Code It In test Desktop");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.goToPage();
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }

    @Test(groups = "Mobile")
    public void codeItInTestForMobile() {
        System.out.println("Code It In test Mobile");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.goToPage();
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }
}
