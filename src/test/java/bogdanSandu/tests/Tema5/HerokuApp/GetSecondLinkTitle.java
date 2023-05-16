package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSecondLinkTitle {

    public static void main(String[] args) {

        getSecondLinkTitle();
    }

    public static void getSecondLinkTitle(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondPageTitle = driver.findElement(By.id("elementattributestest"));
        System.out.println("Second link title is: " + secondPageTitle.getText());
        driver.quit();
    }
}
