package neculaclaudiu.tests.seleniumGrid.seleniumpart3.tests;

import neculaclaudiu.driver.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeMethod(groups = "Desktop")
    public void initChromeBrowser(){
        driver = ChromeDriverManager.createRemoteDriver();
    }

    @BeforeMethod(groups = "Mobile")
    public void initMobileChromeBrowser(){
        driver = ChromeDriverManager.createRemoteDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
