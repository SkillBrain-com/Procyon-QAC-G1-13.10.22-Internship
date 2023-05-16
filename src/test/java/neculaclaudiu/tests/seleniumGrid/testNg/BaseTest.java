package neculaclaudiu.tests.seleniumGrid.testNg;

import neculaclaudiu.driver.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RemoteWebDriver driver;

    @BeforeMethod
    public void initChromeBrowser(){
        driver = ChromeDriverManager.createRemoteDriver();
    }

    @AfterMethod
    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
