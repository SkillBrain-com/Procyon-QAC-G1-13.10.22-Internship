package ancaMarian.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager {
    public static ChromeDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static ChromeDriver createChromeDriverWithOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    public static ChromeDriver createChromeDriverForMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy S8");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static RemoteWebDriver createRemoteWebDriver() {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void maximizeWindow(ChromeDriver driver){
        driver.manage().window().maximize();
    }

    public static void maximizeRemoteWebDriverWindow(RemoteWebDriver driver){
        driver.manage().window().maximize();
    }

    public static void closeChromeDriver(ChromeDriver driver){
        driver.quit();
    }

    public static void closeRemoteWebDriver(RemoteWebDriver driver){
        driver.quit();
    }
}
