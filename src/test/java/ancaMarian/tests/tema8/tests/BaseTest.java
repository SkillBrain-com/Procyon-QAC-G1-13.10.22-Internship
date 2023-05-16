package ancaMarian.tests.tema8.tests;

import ancaMarian.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public ChromeDriver driver;

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
