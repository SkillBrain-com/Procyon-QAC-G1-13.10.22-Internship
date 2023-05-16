package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class GetLinksFromList {

    public static void main(String[] args) {

        getLinksFromList();
    }

    public static void getLinksFromList() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
        List<WebElement> allLinks = driver.findElements(By.tagName("li"));
        System.out.println("Number of Links in the Page is: " + allLinks.size());
        for (WebElement allLink : allLinks) {
            System.out.println(allLink.getText());
        }
        driver.quit();
    }
}
