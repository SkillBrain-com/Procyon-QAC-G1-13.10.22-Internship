package catalinazoldi.tests.Tema8.tests;

import catalinazoldi.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver driver;

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
