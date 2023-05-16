package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
    public static void main(String[] args) {
        goToTheLinks();

    }

    public static void goToTheLinks(){
        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://demoqa.com/links");
        WebElement linksSection = driver.findElement(By.xpath("//span[text()='Links']"));
        linksSection.click();
        WebElement createdLink = driver.findElement(By.xpath("//a[@id='created']"));
        createdLink.click();
        driver.get("https://demoqa.com/links");
        driver.quit();

    }
}
