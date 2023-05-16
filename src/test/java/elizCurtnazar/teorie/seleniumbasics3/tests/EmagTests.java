package elizCurtnazar.teorie.seleniumbasics3.tests;

import elizCurtnazar.driver.BrowserManager;
import elizCurtnazar.teorie.seleniumbasics3.EmagHomePage.EmagHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class EmagTests {
    //ChromeDriver for selenium basics3
//    ChromeDriver driver;
    //RemoteWebDriver dor selenium grid
    RemoteWebDriver driver;

    @Test
    public void openLogin() {
//        ChromeOptions options = new ChromeOptions();// creem obiuectul ChromeOption
//        options.addArguments("start-maximized"); //deschide brwoserul fullscreen
//
//        driver = new ChromeDriver(options); // initializam driver cu options definit
//        driver.get("https://www.emag.ro/");
//        driver.quit();

       // initializam selenium basics 3
//        driver = BrowserManager.createChromeDriverWithOptions();
       //driver initializam selenium grid
        driver = BrowserManager.createRemoteWebDriver();

        driver.get("https://www.emag.ro/");
        System.out.println("Inainte " + LocalDateTime.now());
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //no such element exeption
//        System.out.println("Dupa " + LocalDateTime.now());
//        WebElement acceptButton = driver.findElement(By.className("js-accept"));
//        acceptButton.click();
//        driver.quit();

        //elementClickInterceptedException. explicit wait
        WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .elementToBeClickable(By.className("js-accept")));
        System.out.println("Dupa " + LocalDateTime.now());
//        acceptButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;  //in caz de nu merge .click();
        js.executeScript("arguments[0].click();", acceptButton);//
        driver.quit();
    }

    @Test
    public void openLoginTestWithPageObject() {
        driver = BrowserManager.createChromeDriverWithOptions();
        driver.get("https://www.emag.ro/");
        EmagHomePage emagHomePage = new EmagHomePage(driver);
        emagHomePage.clickOnAcceptButton();
        driver.quit();

    }

    @Test
    public void openMobileBrowser() {

        driver = BrowserManager.createChromeDriverForMobile();
        driver.get("https://www.emag.ro/");

        System.out.println("Inainte " + LocalDateTime.now());
// explicit wait , fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("js-accept")));
        System.out.println("Dupa " + LocalDateTime.now());

        WebElement acceptButton = driver.findElement(By.className("js-accept"));
        JavascriptExecutor js = (JavascriptExecutor) driver;  //in caz de nu merge .click();
        js.executeScript("arguments[0].click();", acceptButton);//
        driver.quit();
    }
}
//https://github.com/pistamarcel/TemaChapter8 pentr tema 8 .grupuri