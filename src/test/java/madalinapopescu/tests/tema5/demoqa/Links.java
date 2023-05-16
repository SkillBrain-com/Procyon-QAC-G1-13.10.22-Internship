package madalinapopescu.tests.tema5.demoqa;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Links {
    public static void main(String[] args) {
        goLinks();
    }
    public static void goLinks() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement links = driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]//li[6]"));
        links.click();
        driver.quit();
    }
}
