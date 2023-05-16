package catalinazoldi.tests.Tema5.DemoqaElements;

import catalinazoldi.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
    public static void main(String[] args){
        goToRadioButtonsPage();
 }

    public static  void goToRadioButtonsPage() {
     ChromeDriver driver = BrowserManager.createChromeDriver();
     driver.get("https://demoqa.com/radio-button");
        WebElement radioButtonYes = driver.findElement(By.cssSelector("label.custom-control-label"));
        radioButtonYes.click();
        WebElement radioButtonImpressive =driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']"));
        radioButtonImpressive.click();
        driver.quit();
    }
}
