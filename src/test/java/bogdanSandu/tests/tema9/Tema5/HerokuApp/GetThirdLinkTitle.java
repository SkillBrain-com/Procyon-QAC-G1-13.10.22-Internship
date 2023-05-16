package bogdanSandu.tests.tema9.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GetThirdLinkTitle {

    public static void main(String[] args) {

        getThirdLinkTitle();
    }

    public static void getThirdLinkTitle(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement thirdLinkPageTitle = driver.findElement(By.xpath("//*[@id=\'findbytest\']"));
        System.out.println("Third link title is: \"" + thirdLinkPageTitle.getText() + "\"");
        driver.quit();
    }
}
