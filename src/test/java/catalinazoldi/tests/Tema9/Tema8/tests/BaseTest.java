package catalinazoldi.tests.Tema9.Tema8.tests;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver driver = null;

    @BeforeMethod(groups = "desktop")
    public void initChromeBrowser() {

        driver = BrowserManager.createChromeDriverWithOptions();
    }

    @BeforeMethod(groups = "mobile")
    public void createChromeDriverForMobile(){
        driver = BrowserManager.createChromeDriverForMobile();
    }
    @AfterMethod(alwaysRun = true, groups = {"mobile","desktop"})
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
        System.out.println("Executed after method");
    }
}
