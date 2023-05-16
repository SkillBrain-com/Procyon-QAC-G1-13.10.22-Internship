package catalinazoldi.tests.Tema9.Tema5.DemoqaElements;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckBox {
    public static void main(String[] args) {
        goToCheckBoxPage();
        }

   public static void  goToCheckBoxPage(){
        RemoteWebDriver driver;
       driver= BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement checkBox = driver.findElement(By.xpath("//label/span[1]"));
        checkBox.click();
        WebElement toggleButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        toggleButton.click();
        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[3]"));
        homeButton.click();
        driver.quit();

    }
}
