package madalinapopescu.tests.tema8.teste;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected ChromeDriver driver;

    @BeforeMethod(groups = "desktop")
    public void initChromeBrowserDesktop() {
        driver = BrowserManager.createChromeDriverWhithOption();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        System.out.println("Executed before method");
    }
    @BeforeMethod(groups = "mobile")
    public void initChromeBrowserMobile() {
        driver = BrowserManager.createChromeDriverForMobile();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        System.out.println("Executed before method");
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        if (driver!=null) {
            driver.quit();
        }
        System.out.println("Executed after method");
    }
}