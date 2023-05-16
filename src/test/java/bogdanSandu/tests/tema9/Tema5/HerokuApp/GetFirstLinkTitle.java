package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetFirstLinkTitle {

    public static void main(String[] args) {

        getFirstLinkTitle();
    }

    public static void getFirstLinkTitle(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement linkTitle = driver.findElement(By.xpath("//*[@id=\'basicpagetest\']"));
        System.out.println("First link title is: \"" + linkTitle.getText() + "\"");
        driver.quit();
    }
}
