package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectWebTables {

    public static void main(String[] args) {

        selectWebTables();
    }

    public static void selectWebTables() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/elements");
        WebElement webTables = driver.findElement(By.id("item-3"));
        webTables.click();
        driver.quit();
    }
}
