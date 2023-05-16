package catalinazoldi.tests.Tema6;

import catalinazoldi.driver.BrowserManager;
import catalinazoldi.utils.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.NoSuchElementException;

public class HerokuAlerts {
     static ChromeDriver driver = null;


     public static void main(String[] args) throws IOException {
          goToHerokuPage();
          try{
               openAlertsPage();
               openAlertBox();
               acceptAlertOnPage();
               openSecondAlertButton();
               acceptSecondAlert();
               openThirdAlertButton();
               acceptAlert();
               closeBrowser();
          }catch(NoSuchElementException e) {
               FileUtils.takeScreenshot(driver, "alert");
          } finally {
               closeBrowser();
          }

     }

     public static void goToHerokuPage(){
          driver = BrowserManager.createChromeDriver();
          driver.get("https://testpages.herokuapp.com/styled/index.html");
          System.out.println("Heroku page a fost deschisa! ");
     }
     public static void openAlertsPage (){
          WebElement alertsLink = driver.findElement(By.id("alerttest"));
          alertsLink.click();
          System.out.println("Pagina de alerte a fost deschisa!");
     }
     public static void openAlertBox() {
          WebElement clickFirstAlertButton = driver.findElement(By.xpath("//input[@id='alertexamples']"));
          clickFirstAlertButton.click();
          System.out.println("Click pe prima alerta!");
     }
           public static void acceptAlertOnPage() {
          Alert firstAlert = driver.switchTo().alert();
          firstAlert.accept();
          System.out.println("Prima alerta a fost acceptata!");
     }
     public static void openSecondAlertButton() {
          WebElement clickSecondAlertButton = driver.findElement(By.xpath("//input[@id='confirmexample']"));
          clickSecondAlertButton.click();
          System.out.println("Click pe cea de-a doua alerta!");
     }
     public static void acceptSecondAlert() {
          Alert secondAlert = driver.switchTo().alert();
          secondAlert.accept();
          System.out.println("A doua alerta a fost acceptata!");
     }
     public static void openThirdAlertButton() {
        WebElement clickThirdAlert = driver.findElement(By.xpath("//*[@id='promptexample']"));
        clickThirdAlert.click();
          System.out.println("Click pe cea de-a treia alerta!");
     }
     public static void acceptAlert() {
          Alert thirdAlert = driver.switchTo().alert();
          thirdAlert.accept();
          System.out.println("A treia alerta a fost accepata!");
     }
     public  static void closeBrowser() {
          driver.quit();
          System.out.println("Am inchis browserul!");
     }
}
