package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.driver.BrowserManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected RemoteWebDriver remoteWebDriver;

    @BeforeMethod(groups = "desktop")
    public void createChromeDriverWithOptions(){
        remoteWebDriver = BrowserManager.createChromeDriverWithOptions();
    }

    @BeforeMethod(groups = "mobile")
    public void createChromeDriverForMobile(){
        remoteWebDriver = BrowserManager.createChromeDriverForMobile();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (remoteWebDriver!=null) {
            remoteWebDriver.quit();
        }
        System.out.println("Chrome instance has been closed!");
    }
}