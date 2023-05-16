package catalinazoldi.tests.Tema5.DemoqaElements;

import catalinazoldi.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
    public static void main(String[] args) {
        goToButtonsPage();
   }

    public static void goToButtonsPage(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();
        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        rightClickMe.click();
        WebElement clickMe = driver.findElement(By.cssSelector(".btn.btn-primary"));
        clickMe.click();
        driver.quit();
        System.out.println("Am rulat testul");
    }
}
