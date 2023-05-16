package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksImages {
    public static void main(String[] args) {
        goToTheBrokenLinksImages();

    }

    public static void goToTheBrokenLinksImages(){

        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://demoqa.com/broken");

        WebElement brokenLinksImagesSection = driver.findElement(By.xpath("//div[@Class='element-list collapse show']/ul/li[7]"));
        brokenLinksImagesSection.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement lastLink = driver.findElement(By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']"));
        lastLink.click();
        driver.get("https://demoqa.com/broken");
        driver.quit();
    }
}
