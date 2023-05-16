package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetFourthLinkTitle {

    public static void main(String[] args) {

        getFourthLinkTitle();
    }

    public static void getFourthLinkTitle(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fourthLinkPageTitle = driver.findElement(By.cssSelector("div h1"));
        System.out.println("Fourth link title is: \"" + fourthLinkPageTitle.getText() + "\"");
        driver.quit();
    }
}
