package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetInformation {

    public static void main(String[] args) {

        getInfo();
    }

    public static void getInfo(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/text-box");
        WebElement getInfo = driver.findElement(By.cssSelector("#output > div"));
        System.out.println("Info: " + getInfo.getText());
        driver.quit();
    }
}
