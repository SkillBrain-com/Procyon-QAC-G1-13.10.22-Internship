package elizCurtnazar.tests.tema7;

import elizCurtnazar.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver driver;

    @BeforeMethod(groups = "redirect") //ruleaza iniante de orice metoda de test
    public void initChromeBrowser() {
        driver = BrowserManager.createDriver();//initializarea
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Executed before method");

    }

    @AfterMethod(groups = "redirect", alwaysRun = true) //alwaysRun = true. metoda mereu da quit, chiar daca e vreo erroare
    public void quitDriver() {
        if(driver!=null) {
            driver.quit();
            System.out.println("Executed after method");
        }
    }
}
