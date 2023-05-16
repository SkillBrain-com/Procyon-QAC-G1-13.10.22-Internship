package andreeaG.tests.tema6;

import andreeaG.driver.BrowserManager;
import andreeaG.utils.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.NoSuchElementException;

public class HerokuAlerts {
    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException {
        navigateToHerokuHomePage();
        try {
            openAlertsPage();
            openFirstAlertOnPage();
            acceptAlertOnPage();
            openAlert();
            acceptAlert();
            thirdAlert();
            acceptThirdAlert();
            closeBrowser();

        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "alert");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuHomePage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis Heroku index page!");
    }

    public static void openAlertsPage() {
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Am navigat catre pagina de alerte!");
    }

    public static void openFirstAlertOnPage() {
        WebElement firstAlertButton = driver.findElement(By.id("alertexamples"));
        firstAlertButton.click();
        System.out.println("Prima alerta");
        ;
    }

    public static void acceptAlertOnPage() {
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        System.out.println("Am acceptat prima alerta!");
    }

    public static void openAlert() {
        WebElement secondAlertButton = driver.findElement(By.id("confirmexample"));
        secondAlertButton.click();
        System.out.println("Am dat click pe secondAlertButton!");
    }

    public static void acceptAlert() {
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();
        System.out.println("Am acceptat a doua alerta!");
    }

    public static void thirdAlert() {
        WebElement thirdAlertButton = driver.findElement(By.id("promptexample"));
        thirdAlertButton.click();
        System.out.println(" Am dat click pe a treia alerta");
    }

        public static void acceptThirdAlert(){
            Alert thirdAlert = driver.switchTo().alert();
            thirdAlert.sendKeys("this or that");
            thirdAlert.accept();
            System.out.println("Am acceptat a treia alerta");
        }

        public static void closeBrowser(){
            driver.quit();
            System.out.println("Am inchis browserul!");
        }
    }
