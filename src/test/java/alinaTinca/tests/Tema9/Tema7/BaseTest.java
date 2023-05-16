package alinatinca.tests.Tema9.Tema7;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import alinatinca.driver.BrowserManager;

public class BaseTest {

    protected RemoteWebDriver remoteWebDriver;
    //create a driver attribute protected

    @BeforeMethod(groups = "redirect")
    public void initChromeBrowser(){
        remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create the driver instance
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/");
        //go to CuraHealthcare page
        System.out.println("Executed before method!");
}
    @AfterMethod(groups = "redirect")
    public void quitDriver(){
        if(remoteWebDriver != null){
            remoteWebDriver.quit();
            //close the driver instance
        }
        System.out.println("Executed after method!");
    }
}