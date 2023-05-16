package ioanandroflorea.tests.Tema8.teste;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ioanandroflorea.driver.BrowserManager;

import java.time.Duration;

public class BaseTest {

    protected ChromeDriver driver;

    @BeforeMethod(groups = "desktop")
    public void createChromeDriverForDesktop(){
        driver = BrowserManager.createChromeDriverForDesktop();
    }

    @BeforeMethod(groups = "mobile")
    public void createChromeDriverForMobile(){
        driver = BrowserManager.createChromeDriverForMobile();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
    }
}
