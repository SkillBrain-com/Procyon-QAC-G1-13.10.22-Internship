
package ioanandroflorea.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    public static ChromeDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static void closeBrowser(ChromeDriver driver) {
        driver.quit();
    }

    public static ChromeDriver createChromeDriverForDesktop() {
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
        return new ChromeDriver(chromeOptions);
    }

    public static RemoteWebDriver createRemoteWebDriver() {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeBrowser(RemoteWebDriver driver) {
        driver.quit();
    }

    public static RemoteWebDriver createRemoteWebDriverForDesktop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new RemoteWebDriver(options);
    }

    public static RemoteWebDriver createRemoteWebDriverForMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy S8");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new RemoteWebDriver(chromeOptions);
    }
}
