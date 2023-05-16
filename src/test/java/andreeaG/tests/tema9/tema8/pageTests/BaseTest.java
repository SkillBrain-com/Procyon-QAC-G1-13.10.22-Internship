package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RemoteWebDriver driver;


    @BeforeMethod(groups ="desktop")
    public void desktopTest() {
        driver= BrowserManager.createRemoteWebDriver();
    }
    @BeforeMethod(groups = "mobile")
    public void mobileTest(){
        driver =BrowserManager.createRemoteWebDriver();
    }
    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
        System.out.println("Executed after method");
    }
}
