package andreeaG.tests.tema5.Demoqa;


import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TextBox {
    public static void main(String[] args) {
        goToTextBox();
        goToEmail();
        goToCurrentAddress();
        goToPermanentAddress();
        submitButton(); }

    private static void goToTextBox() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Ana Norwich");
        driver.quit();
    }

    public static void goToEmail() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("ANorwich@gmail.com");
        driver.quit(); }

    public static void goToCurrentAddress() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(" str. Eroilor, Timisoara");
        driver.quit();
    }

    public static void goToPermanentAddress() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(" str.Noway, China");
        driver.quit();
    }

    public static void submitButton() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement blueSubmitButton = driver.findElement(By.id("submit"));
        blueSubmitButton.click();
        System.out.println( "Am dat click la Submit!");
        driver.quit();
    }
}