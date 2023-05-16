package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetFirstLinkTitle {

    public static void main(String[] args) {

        getFirstLinkTitle();
    }

    public static void getFirstLinkTitle(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement linkTitle = driver.findElement(By.xpath("//*[@id=\'basicpagetest\']"));
        System.out.println("First link title is: \"" + linkTitle.getText() + "\"");
        driver.quit();
    }
}
