package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.tests.tema9.tema8.pageObjects.BasicAjaxPage;
import andreeaG.tests.tema9.tema8.pageObjects.BasicAjaxConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAjaxPageTests extends BaseTest {



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
