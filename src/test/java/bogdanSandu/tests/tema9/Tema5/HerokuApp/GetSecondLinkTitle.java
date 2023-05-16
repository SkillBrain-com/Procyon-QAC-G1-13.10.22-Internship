package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetSecondLinkTitle {

    public static void main(String[] args) {

        getSecondLinkTitle();
    }

    public static void getSecondLinkTitle(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondPageTitle = driver.findElement(By.id("elementattributestest"));
        System.out.println("Second link title is: " + secondPageTitle.getText());
        driver.quit();
    }
}
