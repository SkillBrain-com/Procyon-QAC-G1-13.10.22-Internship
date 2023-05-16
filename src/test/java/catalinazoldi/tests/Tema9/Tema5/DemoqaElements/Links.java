package catalinazoldi.tests.Tema9.Tema5.DemoqaElements;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Links {
    public static void main(String[] args) {
        goToLInksPage();

    }
    public static void  goToLInksPage(){
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/links");
        WebElement createdLink = driver.findElement(By.id("created"));
        System.out.println("Created link displays:" + createdLink.getText());
        createdLink.click();
        WebElement noContentLink = driver.findElement(By.id("no-content"));
        System.out.println("No Content link displays:" + noContentLink.getText());
         noContentLink.click();
        WebElement movedLink = driver.findElement(By.id("moved"));
        System.out.println("Moved Link displays:" + movedLink.getText());
        movedLink.click();
        WebElement badRequestLink = driver.findElement(By.id("bad-request"));
        System.out.println("Bad Request Link displays:" + badRequestLink.getText());
        badRequestLink.click();
        WebElement unauthorizedLink = driver.findElement(By.id("unauthorized"));
        System.out.println("Unauthorized Link displays:" + unauthorizedLink.getText());
        unauthorizedLink.click();
        WebElement forbiddenLink = driver.findElement(By.id("forbidden"));
        System.out.println("Forbidden Link displays:" + forbiddenLink.getText());
        forbiddenLink.click();
        WebElement notFoundLink = driver.findElement(By.id("invalid-url"));
        System.out.println("Not Found Link displays:" + notFoundLink.getText());
        notFoundLink.click();
        driver.close();
        driver.quit();
        System.out.println("Testul s-a rulat!");
    }
}
