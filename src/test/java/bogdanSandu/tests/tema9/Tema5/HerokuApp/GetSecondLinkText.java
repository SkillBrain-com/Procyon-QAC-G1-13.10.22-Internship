package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetSecondLinkText {

    public static void main(String[] args) {

        getSecondtLinkText();
    }

    public static void getSecondtLinkText(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");
        WebElement linkText = driver.findElement(By.cssSelector("body > div > div.explanation > p"));
        System.out.println("Second link text is: \"" + linkText.getText() + "\"");
        driver.quit();
    }
}
