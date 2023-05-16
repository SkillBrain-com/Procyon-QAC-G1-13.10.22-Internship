package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.tests.tema9.tema8.pageObjects.JavascriptRedirectButtons;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptRedirectButtonsTest extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void verifyRedirectJavascript() {
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        JavascriptRedirectButtons javascriptRedirectButtons = new JavascriptRedirectButtons(driver);
        javascriptRedirectButtons.clickOn5Seconds();
        javascriptRedirectButtons.clickOn2seconds();
        Assert.assertEquals("JavaScript Redirect Test Page", driver.getTitle());
    }
}
