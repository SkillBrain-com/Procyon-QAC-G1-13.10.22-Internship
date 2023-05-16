package neculaclaudiu.tests.seleniumGrid.seleniumpart2;

import neculaclaudiu.driver.ChromeDriverManager;
import neculaclaudiu.utils.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class HerokuAlerts {
    static RemoteWebDriver driver = null;
    public static void main(String[] args) {
        navigateToHerokuHomePage();
        try {
            openAlertsPage();
            openFirstAlert();
            acceptAlert();
            openSecondAlert();
            dismissAlert();
            openThirdAlert();
            sendKeysToAlert();
            acceptAlert();
            nonExistentElement();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "alerts");
        }finally {
            closeBrowser();
        }
    }
    public static void navigateToHerokuHomePage(){
        driver = ChromeDriverManager.createRemoteDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis index page-ul");
    }
    public static void openAlertsPage() {
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Am deschis pagina cu alerte");
    }

    public static void closeBrowser(){
        driver.quit();
        System.out.println("am inchis browser-ul");
    }
    public static void openSecondAlert(){
        WebElement secondAlertBox = driver.findElement(By.id("confirmexample"));
        secondAlertBox.click();
        System.out.println("Am dat click pe butonul confirm alert");
    }
    public static void openFirstAlert(){
        WebElement alertBox = driver.findElement(By.id("alertexamples"));
        alertBox.click();
    }
    public static void openThirdAlert(){
        WebElement promptBox = driver.findElement(By.id("promptexample"));
        promptBox.click();
        System.out.println("Am deschis a treia alerta");
    }
    public static void dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        System.out.println("Am dat dismiss la alert");
    }
    public static void acceptAlert(){
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        System.out.println("Am acceptat alerta");

    }
    public static void sendKeysToAlert(){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        System.out.println("Am dat sendkeys la alerta");
    }
    public static void nonExistentElement(){
        WebElement nonExistent = driver.findElement(By.cssSelector("nonexistent"));
        nonExistent.click();
    }
}

