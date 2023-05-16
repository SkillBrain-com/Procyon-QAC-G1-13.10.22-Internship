package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) {
        goToTheCheckBox();

    }
    public static void goToTheCheckBox(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement checkBoxSection = driver.findElement(By.xpath("//span[text()='Check Box']"));
        checkBoxSection.click();
        WebElement checkBox = driver.findElement(By.cssSelector(".rct-checkbox svg[stroke='currentColor']"));
        checkBox.click();
        driver.quit();

    }
}
