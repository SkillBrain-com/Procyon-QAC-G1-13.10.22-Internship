package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FourthLinkOpen {

    public static void main(String[] args) {

        fourthLinkOpen();
    }

    public static void fourthLinkOpen(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fourthLink = driver.findElement(By.id("tablestest"));
        fourthLink.click();
        driver.quit();
    }
}
