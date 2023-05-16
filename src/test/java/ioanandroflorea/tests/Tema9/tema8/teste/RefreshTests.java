package ioanandroflorea.tests.Tema9.tema8.teste;

import ioanandroflorea.driver.BrowserManager;
import ioanandroflorea.tests.Tema9.tema8.pageObjects.RefreshPage;
import ioanandroflorea.tests.Tema9.tema8.teste.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshTests extends BaseTest {
    @Test(groups = {"mobile", "desktop"})
    public void refreshPage(){
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        RefreshPage refreshPage = new RefreshPage(driver);
        driver.navigate().refresh();
        Assert.assertEquals(refreshPage.getTimestamp(), refreshPage.getTimestamp(), "Timestamp has been changed!");
    }
}
