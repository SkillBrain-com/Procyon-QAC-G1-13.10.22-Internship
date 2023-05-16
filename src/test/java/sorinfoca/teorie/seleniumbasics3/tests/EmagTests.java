package sorinfoca.teorie.seleniumbasics3.tests;

import sorinfoca.teorie.seleniumbasics3.pageObjects.EmagHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import sorinfoca.driver.BrowserManager;

import java.time.Duration;
import java.time.LocalDateTime;

public class EmagTests {

 //   ChromeDriver driver;

    RemoteWebDriver driver;

    @Test
    public void openLoginTest() {
        //driver initialisation for selenium basics 3
        //driver = BrowserManager.createChromeDriverWithOptions();
        //driver initialisation for selenium grid
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://www.emag.ro");
        System.out.println("Inainte " + LocalDateTime.now());
        //         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //    WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(10)) .until(ExpectedConditions.elementToBeClickable(By.className("js-accept")));
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-accept")));
        System.out.println("Dupa " + LocalDateTime.now());
        WebElement acceptButton = driver.findElement(By.className("js-accept"));
//          acceptButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", acceptButton);
        driver.quit();
    }

    @Test
    public void openLoginTestWithPageObject() {
            driver = BrowserManager.createChromeDriverWithOptions();
            driver.get("https://www.emag.ro");
            EmagHomePage emagHomePage = new EmagHomePage(driver);
            emagHomePage.clickOnAcceptButton();
            driver.quit();
        }

    @Test
    public void openMobileBrowser() {
            driver = BrowserManager.createChromeDriverForMobile();
            driver.get("https://www.emag.ro/");
            driver.quit();
        }
    }
