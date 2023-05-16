package elizCurtnazar.tests.tema6;

import elizCurtnazar.driver.BrowserManager;
import elizCurtnazar.utils.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class HerokuAlerts {

    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException {
        navigateToHerokuHomePage();
        openAlertsPage();
        openFirstAlert();
        acceptFirstAlert();
        openSecondAlert();
        acceptAlert();
        openThirdAlert();
        acceptThirdAlert();
        try {
            openFakeAlertsPage();
            System.out.println("Am intrat in blocul de try.");

        } catch (NoSuchElementException e) {
            System.out.println("Am intrat pe blocul de catch");
            FileUtils.takeScreenshot(driver, "Fake Alert page");
            //alta variante de rezolvare
//            File file = driver.getScreenshotAs(OutputType.FILE);
//            File destinationFile = new File("C:\\Users\\Deniz\\IdeaProjects\\poza.png");
//            FileUtils.copyFile(file, destinationFile);

        } finally {
            closeBrowser();
            System.out.println("Am inchis pagina de pe blocul de finally");
        }


//        EXEMPLU DIN ORE
//        navigateToHerokuHomePage();
//        try {
//            openAlertsPage();
//        } catch (NoSuchElementException e) {
//            FileUtils.takeScreenshot(driver, "alert");
//            File source = driver.getScreenshotAs(OutputType.FILE);
//            String destinationFile = System.getProperty("user.dir") +"/Logs/printScreen.png";
//            FileUtils.copyFile(source, new File(destinationFile));
//        } finally {
//            closeBrowser();
//        }

        }

        public static void navigateToHerokuHomePage () {
            driver = BrowserManager.createDriver();
            driver.get("https://testpages.herokuapp.com/styled/index.html");
            System.out.println("Am deschis Heroku index page!");
        }

        public static void openAlertsPage () {
            WebElement alertsLink = driver.findElement(By.id("alerttest"));
            alertsLink.click();
            System.out.println("Am navigat catre alerts page!");
            WebElement getText = driver.findElement(By.cssSelector("div.explanation"));
            System.out.println(getText.getText());
        }

        public static void openFirstAlert () {
            WebElement firstAlertButton = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
            firstAlertButton.click();
            System.out.println("Am dat click pe firstAlertButton.");
        }

        public static void acceptFirstAlert () {
            Alert firstAlert = driver.switchTo().alert();
            firstAlert.accept();
            System.out.println("Am acceptat alerta.");
        }

        public static void openSecondAlert () {
            WebElement secondAlertButton = driver.findElement(By.xpath("/html/body/div/div[4]/input"));
            secondAlertButton.click();
            System.out.println("Am dat click pe secondAlertButton.");
        }

        public static void acceptAlert () {
            Alert secondAlert = driver.switchTo().alert();
            secondAlert.accept();
            System.out.println("Am acceptat alerta.");
        }

        public static void openThirdAlert () {
            WebElement thirdAlertButton = driver.findElement(By.xpath("/html/body/div/div[5]/input"));
            thirdAlertButton.click();
            System.out.println("Am dat click pe thirdAlertButton.");
        }

        public static void acceptThirdAlert () {
            Alert thirdAlert = driver.switchTo().alert();
            thirdAlert.sendKeys("Click ok!");
            thirdAlert.accept();
            System.out.println("Am acceptat alerta.");
        }

        public static void openFakeAlertsPage () {
            WebElement fakeAlertsPage = driver.findElement(By.id("fakealerttest"));
            fakeAlertsPage.click();
            System.out.println("Am navigat pe pagina Fake Alerts!");
            WebElement textFakeAlertsPage = driver.findElement(By.cssSelector("div.explanation"));
            System.out.println(textFakeAlertsPage.getText());
        }

        public static void closeBrowser () {
            driver.quit();
            System.out.println("Am inchis browserul!");
        }
    }
