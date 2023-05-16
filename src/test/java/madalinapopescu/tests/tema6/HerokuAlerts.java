package madalinapopescu.tests.tema6;
import madalinapopescu.driver.BrowserManager;
import madalinapopescu.utils.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import static madalinapopescu.tests.tema6.DemoQaWindow.closeBrowser;
public class HerokuAlerts {
    static ChromeDriver driver = null;
    public static void main(String[] args) throws IOException {
        navigateToHerokuHomePage();
        openAlertsPage();
        try {
            openFirstAlert();
            openSecondAlert();
            getAlertText();
            dismissAlert();
            openThirdAlert();
            findElementNonexistent();
        } catch (NoSuchElementException e){
//            FileUtils.takeScreenshot(driver,"alert");
            FileUtils.takeScreenshot(driver, "alba-ca-zapada");
            System.out.println("Am intrat in blocul de catch");
            System.out.println("Nu exista nici un element cu id 'alba-ca-zapada'");
        } finally {
            closeBrowser();
        }
    }
    public static void navigateToHerokuHomePage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis Heroku index page");
    }
    public static void openAlertsPage() {
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Am navigat catre alerts page");
    }
    public static void openFirstAlert() {
        WebElement firstAlertButton = driver.findElement(By.id("alertexamples"));
        firstAlertButton.click();
        Alert firstAlert = driver.switchTo().alert();
        System.out.println("Textul din prima alerta este: " + firstAlert.getText());
        firstAlert.accept();
    }
    public static void openSecondAlert(){
        WebElement secondAlertButton = driver.findElement(By.xpath("//input[@id='confirmexample']"));
        secondAlertButton.click();
        System.out.println("Am dat clic pe secondAlertButton");
    }
    public static void acceptAlert(){
        Alert sendAlert = driver.switchTo().alert();
        sendAlert.accept();
        System.out.println("Am acceptat alerta");
    }
    public static void dismissAlert() {
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.dismiss();
        System.out.println("Am anulat a doua alerta!");
    }
    public static void getAlertText(){
        Alert secondAlert = driver.switchTo().alert();
        System.out.println("Textul din a doua alerta este: " + secondAlert.getText());
    }
    public static void openThirdAlert() {
        WebElement clickThirdAlertButton = driver.findElement(By.id("promptexample"));
        clickThirdAlertButton.click();
        Alert thirdAlert = driver.switchTo().alert();
        System.out.println("Textul din a3-a alerta este: " + thirdAlert.getText());
        thirdAlert.sendKeys("Textul meu!");
        thirdAlert.accept();
        System.out.println("Am introdus un text in a 3-a alerta");
    }
        public static void findElementNonexistent() {
            WebElement nonExistentElement = driver.findElement(By.id("alba-ca-zapada"));
            nonExistentElement.click();
            System.out.println("Caut un element cu id `alba-ca-zapada");
        }
        public static void closeBrowser(){
            driver.quit();
            System.out.println("Am inchis browserul");
        }
    }

