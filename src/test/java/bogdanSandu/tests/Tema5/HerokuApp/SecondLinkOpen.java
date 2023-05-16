package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondLinkOpen {

    public static void main(String[] args) {

        secondLinkOpen();
    }

    public static void secondLinkOpen(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();
        driver.quit();
    }
}
