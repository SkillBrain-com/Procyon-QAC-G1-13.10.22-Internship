package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.tests.Tema9.Tema8.pageObjects.BasicAjaxExampleConfirmationPage;
import alinatinca.tests.Tema9.Tema8.pageObjects.BasicAjaxExamplePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAjaxExamplePageTests extends BaseTest{

    @Test(groups = {"mobile", "desktop"})
    public void getFirstCategory() {
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxExamplePage herokuBasicAjaxExamplePage = new BasicAjaxExamplePage(remoteWebDriver);
        System.out.println("The message from the paragraph is: " + herokuBasicAjaxExamplePage.displayParagraph());
        herokuBasicAjaxExamplePage.selectCategory("Web");
        System.out.println("Web item from drop down category list has been selected!");
        herokuBasicAjaxExamplePage.selectLanguage("Javascript");
        System.out.println("Javascript item from drop down language list has been selected!");
        herokuBasicAjaxExamplePage.clickOnCodeInIt();
        BasicAjaxExampleConfirmationPage herokuBasicAjaxExampleConfirmationPage = new BasicAjaxExampleConfirmationPage(remoteWebDriver);
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryID(), "1");
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryLanguage(), "1");
    }

    @Test(groups = {"mobile", "desktop"})
    public void getSecondCategory() {
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxExamplePage herokuBasicAjaxExamplePage = new BasicAjaxExamplePage(remoteWebDriver);
        System.out.println("The message from the paragraph is: " + herokuBasicAjaxExamplePage.displayParagraph());
        herokuBasicAjaxExamplePage.selectCategory("Desktop");
        System.out.println("Desktop item from drop down category list has been selected!");
        herokuBasicAjaxExamplePage.selectLanguage("C++");
        System.out.println("C++ item from drop down language list has been selected!");
        herokuBasicAjaxExamplePage.clickOnCodeInIt();
        BasicAjaxExampleConfirmationPage herokuBasicAjaxExampleConfirmationPage = new BasicAjaxExampleConfirmationPage(remoteWebDriver);
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryID(), "2");
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryLanguage(), "10");
    }

    @Test(groups = {"mobile", "desktop"})
    public void getThirdCategory() {
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxExamplePage herokuBasicAjaxExamplePage = new BasicAjaxExamplePage(remoteWebDriver);
        System.out.println("The message from the paragraph is: " + herokuBasicAjaxExamplePage.displayParagraph());
        herokuBasicAjaxExamplePage.selectCategory("Server");
        System.out.println("Server item from drop down category list has been selected!");
        herokuBasicAjaxExamplePage.selectLanguage("Java");
        System.out.println("Java item from drop down language list has been selected!");
        herokuBasicAjaxExamplePage.clickOnCodeInIt();
        BasicAjaxExampleConfirmationPage herokuBasicAjaxExampleConfirmationPage = new BasicAjaxExampleConfirmationPage(remoteWebDriver);
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryID(), "3");
        Assert.assertEquals(herokuBasicAjaxExampleConfirmationPage.getCategoryLanguage(), "23");
    }
}