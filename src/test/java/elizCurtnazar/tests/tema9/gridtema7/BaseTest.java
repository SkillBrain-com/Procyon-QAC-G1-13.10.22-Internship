package elizCurtnazar.tests.tema9.gridtema7;

import elizCurtnazar.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver remoteWebDriver;

    @BeforeMethod(groups = "redirect") //ruleaza iniante de orice metoda de test
    public void initChromeBrowser() {
        remoteWebDriver = BrowserManager.createRemoteWebDriver();//initializarea
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Executed before method");

    }

    @AfterMethod(groups = "redirect", alwaysRun = true) //alwaysRun = true. metoda mereu da quit, chiar daca e vreo erroare
    public void quitDriver() {
        if(remoteWebDriver !=null) {
            remoteWebDriver.quit();
            System.out.println("Executed after method");
        }
    }
}
