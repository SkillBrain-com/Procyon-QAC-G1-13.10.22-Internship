package cosminsechel.tests.tema7.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import cosminsechel.driver.BrowserManager;

public class TestConfig {

    protected RemoteWebDriver driver;
    private static String baseUrl = "https://katalon-demo-cura.herokuapp.com/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    @BeforeTest
    public void beforeTest() { System.out.println("Before test"); }

    @AfterTest
    public void afterTest() { System.out.println("After test"); }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Before method");
        driver = BrowserManager.createRemoteWebDriver();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
        BrowserManager.closeRemoteWebDriver(driver);
    }
}
