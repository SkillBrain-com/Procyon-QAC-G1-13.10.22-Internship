package elizCurtnazar.tests.tema9.gridtema8.teste;

import elizCurtnazar.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver remoteWebDriver;

    @BeforeMethod(groups = "desktop")
    public void initChromeBrowser() {
        remoteWebDriver = BrowserManager.createChromeDriverWithOptions();

    }
    @BeforeMethod(groups = "mobile")
    public void  createChromeDriverForMobile() {

        remoteWebDriver = BrowserManager.createChromeDriverForMobile();
    }
    @AfterMethod(alwaysRun = true, groups = {"mobile","desktop"})
    public void quitDriver() {
        if (remoteWebDriver !=null) {
            remoteWebDriver.quit();
        }
        System.out.println("Executed after method");
    }
}
