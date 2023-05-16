package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstLinkOpen {

    public static void main(String[] args) {

        firstLinkOpen();
    }

    public static void firstLinkOpen(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        firstLink.click();
        driver.quit();
    }
}
