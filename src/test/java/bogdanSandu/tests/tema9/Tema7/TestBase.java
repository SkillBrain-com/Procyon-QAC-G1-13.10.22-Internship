package bogdanSandu.tests.tema9.Tema7;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected RemoteWebDriver driver;

    @BeforeMethod
    public void openCURAHealthPage() {
        //open home page
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Am deschis CURA Healthcare Service page");
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        System.out.println("Close browser");
    }
}
