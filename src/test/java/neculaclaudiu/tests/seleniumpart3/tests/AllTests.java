package neculaclaudiu.tests.seleniumpart3.tests;

import neculaclaudiu.tests.seleniumpart3.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AllTests extends BaseTest{

    @Test(groups = {"Desktop", "Mobile"})
    public void ajaxPageTest(){
        BasicAjaxPage page = new BasicAjaxPage(driver);
        page.selectCategory("Desktop");
        page.selectLanguage("Visual Basic");
        page.clickOnCodeInButton();
        BasicAjaxVerificationPage verificationPage = new BasicAjaxVerificationPage(driver);
        Assert.assertEquals(verificationPage.getCategoryText(),"2");
        Assert.assertEquals(verificationPage.getLanguageText(),"13");
    }

    @Test(groups = {"Desktop", "Mobile"})
    public void javaScriptRedirectsPageTest(){
        JavaScriptRedirectsPage page = new JavaScriptRedirectsPage(driver);
        page.clickOnFirstButton();
        page.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(),"https://testpages.herokuapp.com/styled/redirected.html");
        page.goBackButton();
        page.clickOnTheSecondButton();
        page.waitForRedirect();
        Assert.assertEquals(driver.getCurrentUrl(),"https://testpages.herokuapp.com/styled/redirected.html");
    }

    @Test(groups = {"Desktop", "Mobile"})
    public void refreshPageTest(){
        RefreshPage page = new RefreshPage(driver);
        String refresh1 = page.getRefreshNumber();
        driver.navigate().refresh();
        String refresh2 = page.getRefreshNumber();
        Assert.assertNotEquals(refresh1,refresh2);
    }

    @Test(groups = {"Desktop", "Mobile"})
    public void simpleDynamicButtonsPageTest(){
        SimpleDynamicButtonsPage page = new SimpleDynamicButtonsPage(driver);
        page.clickOnStartButton();
        page.clickOnOneButton();
        page.clickOnTwoButton();
        page.clickOnThreeButton();
        Assert.assertEquals(page.buttonMessageGetText(), "All Buttons Clicked");
    }

    @Test(groups = {"Desktop", "Mobile"})
    public void disabledDynamicButtonsTest(){
        DisabledDynamicButtonsPage page = new DisabledDynamicButtonsPage(driver);
        page.clickOnStartButton();
        page.clickOnOneButton();
        page.clickOnTwoButton();
        page.clickOnThreeButton();
        Assert.assertEquals(page.buttonMessageGetText(), "All Buttons Clicked");
    }


}
