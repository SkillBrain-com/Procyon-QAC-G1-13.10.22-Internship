package ancaMarian.tests.tema9.tema8.tests;

import ancaMarian.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RemoteWebDriver driver;

    @BeforeMethod(groups = "desktop")
    public void setUpDesktop() {
        driver = BrowserManager.createChromeDriverWithOptions();
    }

    @BeforeMethod(groups = "mobile")
    public void setUpMobile() {
        driver = BrowserManager.createChromeDriverForMobile();
    }

    @AfterMethod(alwaysRun = true)
     public void closeBrowser() {
        driver.quit();
    }
}
