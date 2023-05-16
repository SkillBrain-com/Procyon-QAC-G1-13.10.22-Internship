package cosminneagu.teorie.seleniumbasicspart2;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AlertExample {

    public static void main(String[] args) {
      //  openAndSubmitAlert();
    }

    static void openAndSubmitAlert() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.createChromeDriver();
            driver.get("https://demoqa.com/alerts");
            WebElement thirdAlertButton = driver.findElement(By.id("confirmButton"));
            thirdAlertButton.click();
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println("Am intrat in catch");
        } finally {
            if (driver!=null) {
                driver.quit();
            }
        }
    }
}
