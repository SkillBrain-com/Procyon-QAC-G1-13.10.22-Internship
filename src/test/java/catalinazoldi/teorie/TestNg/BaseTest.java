package catalinazoldi.teorie.TestNg;

import catalinazoldi.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected ChromeDriver driver;


    @BeforeMethod(groups = "redirect")
    public void initChromeBrowser() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Executed before method. ");

    }
    @AfterMethod(groups = "redirect")
    public void quitDriver(){
        if(driver !=null) {
            driver.quit();
        }
        System.out.println("Executed after method");

    }
}
