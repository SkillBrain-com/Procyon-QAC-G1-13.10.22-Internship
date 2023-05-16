package ancaMarian.tests.tema7;

import ancaMarian.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Configurations {

    ChromeDriver driver = null;

    public String url = "https://katalon-demo-cura.herokuapp.com/";

    @BeforeMethod
    public void setupDriver() {
        driver = BrowserManager.createDriver();
        System.out.println("Am deschis browserul.");
    }

    @AfterMethod
    public void closeDriver() {
        if (driver!=null) {driver.quit();}
        System.out.println("Am inchis browserul.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }
}
