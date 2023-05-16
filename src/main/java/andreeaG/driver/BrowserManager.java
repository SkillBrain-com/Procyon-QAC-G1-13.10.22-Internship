package andreeaG.driver;

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

    public static ChromeDriver createChromeDriverWithOptions() {
        //creating a ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        //set fullscreen option
        options.addArguments("start-maximized");
        //initialise driver with options defined above
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    public static ChromeDriver createChromeDriverForMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        // Map stocheaza cheie -> valoare
        //"Vulpe" -> "Rosu"
        //"Urs" -> "Negru"
        //"Caine" -> "Maro"
        mobileEmulation.put("deviceName", "Galaxy Fold");
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

    public static RemoteWebDriver createRemoteWebDriverForDesktop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        return new RemoteWebDriver(options);
    }

    public static RemoteWebDriver createRemoteWebDriverForMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy Fold");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        return new RemoteWebDriver(chromeOptions);
    }
}

