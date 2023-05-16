package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetFirstLinkText {

    public static void main(String[] args) {

        getFirstLinkText();
    }

    public static void getFirstLinkText(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        WebElement linkText = driver.findElement(By.cssSelector("body > div > div.explanation"));
        System.out.println("First text is: \"" + linkText.getText() + "\"");
        driver.quit();
    }
}
