package elizCurtnazar.teorie;

import elizCurtnazar.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DemoQaInputs {
    ChromeDriver driver;

    @Test
    public void test1(){
        driver = BrowserManager.createDriver();
        driver.get("https://demoqa.com/text-box");
        writeFullName();
        writeEmail();
        writeCurrentAddress();
        writePermanentAddress();
        driver.quit();
    }


    public void writeFullName() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Eliz Curtnazar");
    }

    public  void writeEmail() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("eliz_rts_91@hotmail.com");
    }

    public void writeCurrentAddress() {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Lumina");
    }

    public void writePermanentAddress() {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Navodari");
    }
}
