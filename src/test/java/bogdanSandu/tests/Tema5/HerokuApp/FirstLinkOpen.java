package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstLinkOpen {

    public static void main(String[] args) {

        firstLinkOpen();
    }

    public static void firstLinkOpen(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        firstLink.click();
        driver.quit();
    }
}
