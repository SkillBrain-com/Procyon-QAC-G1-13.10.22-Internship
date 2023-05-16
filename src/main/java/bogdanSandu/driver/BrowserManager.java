package bogdanSandu.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager {

    public static ChromeDriver createDriverAndGetPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverForDesktop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    public static ChromeDriver getChromedriverForMobile(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, String> map = new HashMap<>();
        map.put("deviceName", "Galaxy Fold");
        chromeOptions.setExperimentalOption("mobileEmulation", map);
        return new ChromeDriver(chromeOptions);
    }

    public static RemoteWebDriver createRemoteWebDriver(){
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/"), new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeBrowser(RemoteWebDriver driver){
        driver.quit();
    }
}
