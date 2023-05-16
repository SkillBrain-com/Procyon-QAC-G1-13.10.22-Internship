package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SecondLinkOpen {

    public static void main(String[] args) {

        secondLinkOpen();
    }

    public static void secondLinkOpen(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();
        driver.quit();
    }
}
