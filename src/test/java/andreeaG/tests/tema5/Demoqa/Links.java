package andreeaG.tests.tema5.Demoqa;


import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Links {

    public static void main(String[] args) {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get ("https://demoqa.com/links");
        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        System.out.println("Home link displays:  " + homeLink.getText());
        homeLink.click();
        WebElement homeZu8bgLink = driver.findElement(By.id("dynamicLink"));
        System.out.println("HomeZU8BG link displays:  " + homeZu8bgLink.getText());
        homeZu8bgLink.click();
        WebElement createdLink = driver.findElement(By.id("created"));
        System.out.println("Created link displays:  " + createdLink.getText());
        createdLink.click();
        WebElement nocontentLink = driver.findElement(By.id("no-content"));
        System.out.println("No Content link displays:  " + nocontentLink.getText());
        nocontentLink.click();
        WebElement movedLink = driver.findElement(By.id("moved"));
        System.out.println("Moved link displays:  " + movedLink.getText());
        movedLink.click();
        WebElement badRequestLink = driver.findElement(By.id("bad-request"));
        System.out.println("Bad Request link displays:  " + badRequestLink.getText());
        badRequestLink.click();
        WebElement unauthorizedLink = driver.findElement(By.id("unauthorized"));
        System.out.println("Unauthorized link displays:  " + unauthorizedLink.getText());
        unauthorizedLink.click();
        WebElement forbiddenLink = driver.findElement(By.id("forbidden"));
        System.out.println("Forbidden link displays:  " + forbiddenLink.getText());
        forbiddenLink.click();
        WebElement notFoundLink = driver.findElement(By.id("invalid-url"));
        System.out.println("Not found link displays:  " + notFoundLink.getText());
        notFoundLink.click();
        driver.close();
        driver.quit();
    }
}
