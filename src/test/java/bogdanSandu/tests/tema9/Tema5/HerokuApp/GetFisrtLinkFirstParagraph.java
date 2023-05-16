package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetFisrtLinkFirstParagraph {

    public static void main(String[] args) {

        getFirstParagraph();
    }

    public static void getFirstParagraph(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-web-page-test.html");
        WebElement paragraph = driver.findElement(By.id("para1"));
        System.out.println("First paragraph is: \"" + paragraph.getText() + "\"");
        BrowserManager.closeBrowser(driver);
    }
}
