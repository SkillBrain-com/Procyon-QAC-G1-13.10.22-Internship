package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetFourthLinkTitle {

    public static void main(String[] args) {

        getFourthLinkTitle();
    }

    public static void getFourthLinkTitle(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fourthLinkPageTitle = driver.findElement(By.cssSelector("div h1"));
        System.out.println("Fourth link title is: \"" + fourthLinkPageTitle.getText() + "\"");
        driver.quit();
    }
}
