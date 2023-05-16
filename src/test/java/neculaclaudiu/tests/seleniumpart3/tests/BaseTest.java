package neculaclaudiu.tests.seleniumpart3.tests;

import neculaclaudiu.driver.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {

    protected ChromeDriver driver;

    @BeforeMethod(groups = "Desktop")
    public void initChromeBrowser(){
        driver = ChromeDriverManager.createChromeDriverWithOptions();
    }

    @BeforeMethod(groups = "Mobile")
    public void initMobileChromeBrowser(){
        driver = ChromeDriverManager.createChromeDriverForMobile();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
