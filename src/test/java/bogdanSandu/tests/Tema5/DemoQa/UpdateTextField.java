package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UpdateTextField {

    public static void main(String[] args) {

        updateTextField();
    }

    public static void updateTextField() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.clear();
        fullName.sendKeys("Bob ");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("adresamail@gmail.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.clear();
        currentAddress.sendKeys("Str. No.");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.clear();
        permanentAddress.sendKeys("Str. Abc, No.2");
        WebElement clickSubmitButton = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickSubmitButton);
        actions.perform();
        clickSubmitButton.click();
        driver.quit();
    }
}
