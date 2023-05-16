package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ThirdLinkOpen {

    public static void main(String[] args) {

        thirdLinkOpen();
    }

    public static void thirdLinkOpen(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement thirdLink = driver.findElement(By.id("findbytest"));
        thirdLink.click();
        driver.quit();
    }
}
