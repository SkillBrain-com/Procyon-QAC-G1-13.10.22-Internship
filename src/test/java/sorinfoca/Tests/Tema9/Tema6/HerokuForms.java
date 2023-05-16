package sorinfoca.Tests.Tema9.Tema6;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import sorinfoca.driver.BrowserManager;

import java.io.File;

public class HerokuForms {

    static RemoteWebDriver driver;
    private static File screenshot;

    public static void main(String[] args) throws InterruptedException {
        navigateToHerokuHomePage();
        try {
            fillOutForm();
            scrollToSubmitButton();
            submitForm();
        } catch (NoSuchElementException e) {
            sorinfoca.utils.FileUtils.takeScreenshot(driver, "alert");
            System.out.println("No alert present");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuHomePage() {
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        System.out.println("Am deschis Heroku Forms page");
    }

    public static void fillOutForm() throws InterruptedException {
        WebElement nameField = driver.findElement(By.name("username"));
        nameField.sendKeys("Sorin Foca");
        System.out.println("Am completat username");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password123");
        System.out.println("Am completat parola");
        WebElement commentField = driver.findElement(By.name("comments"));
        commentField.sendKeys("Comment for Selenium script by Foca Sorin Cristian.");
        System.out.println("Am completat comment-ul");
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]"));
        checkbox1.click();
        System.out.println("Am completat checkbox1");
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]"));
        checkbox2.click();
        System.out.println("Am completat checkbox2");
        WebElement radio = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]"));
        radio.click();
        System.out.println("Am apasat radio1");
        Thread.sleep(3000);
    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
    }
    public static void submitForm() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Form submitted");
    }

    public static void closeBrowser() {
        driver.quit();
        System.out.println("Am inchis browserul");
    }
}