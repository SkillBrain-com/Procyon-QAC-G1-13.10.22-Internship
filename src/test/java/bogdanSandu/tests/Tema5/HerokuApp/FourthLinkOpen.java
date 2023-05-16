package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthLinkOpen {

    public static void main(String[] args) {

        fourthLinkOpen();
    }

    public static void fourthLinkOpen(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fourthLink = driver.findElement(By.id("tablestest"));
        fourthLink.click();
        driver.quit();
    }
}
