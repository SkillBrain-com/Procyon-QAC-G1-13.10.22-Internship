package andreeaG.tests.tema9.tema7;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeMethod(groups = {"redirect", "login"})
    public void initChromeBrowser() {
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Executed before method");
    }

    @AfterMethod(alwaysRun=true, groups = {"redirect", "login", "Home Button"})
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
        System.out.println("Executed after method");
    }
}
