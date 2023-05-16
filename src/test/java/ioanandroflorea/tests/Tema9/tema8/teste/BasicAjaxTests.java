package ioanandroflorea.tests.Tema9.tema8.teste;

import org.testng.Assert;
import org.testng.annotations.Test;
import ioanandroflorea.tests.Tema9.tema8.pageObjects.BasicAjaxConfirmationPage;
import ioanandroflorea.tests.Tema9.tema8.pageObjects.BasicAjaxPage;

public class BasicAjaxTests extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void codeItInTest() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.selectCategory("Desktop");
        basicAjaxPage.selectLanguage("Assembler");
        basicAjaxPage.clickOnSubmitButton();
        BasicAjaxConfirmationPage basicAjaxConfirmationPage = new BasicAjaxConfirmationPage(driver);
        Assert.assertEquals(basicAjaxConfirmationPage.getCategoryText(), "2");
    }
}
