package madalinapopescu.tests.tema5.demoqa;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        goToTextBox();
    }
    public static void goToTextBox() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement textBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]"));
        textBox.click();
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.clear();
        fullName.sendKeys("Ion Vasile");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("abc@mail.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.clear();
        currentAddress.sendKeys("Alba ca zapada");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.clear();
        permanentAddress.sendKeys("Cei sapte pitici");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.sendKeys(Keys.ENTER);
        driver.quit();
    }
}
