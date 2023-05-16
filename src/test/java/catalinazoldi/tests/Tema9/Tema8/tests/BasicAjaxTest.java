package catalinazoldi.tests.Tema9.Tema8.tests;


import catalinazoldi.tests.Tema9.Tema8.pageObjects.BasicAjaxPage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicAjaxTest extends BaseTest {

    @Test(groups = "desktop")
    public void codeItInTestForDesktop() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        System.out.println("Code It In test Desktop");
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }

    @Test(groups = "mobile")
    public void codeItInTestForMobile() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        System.out.println("Code It In test Mobile");
        System.out.println("Got to 'Basic Ajax Example' link");
        basicAjaxPage.selectCategory(1);
        System.out.println("Select category");
        basicAjaxPage.selectLanguage(2);
        System.out.println("Select language");
        basicAjaxPage.clickOnButton();
    }
}
