package catalinazoldi.tests.Tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicButtonsSimplePage {
    static WebDriver driver;
     static WebDriverWait wait;
    Wait<WebDriver> fluentWait;


    public DynamicButtonsSimplePage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "button00")
    WebElement startButton;

    public void clickOnStartButton(){

        startButton.click();
    }
    public void clickOnOneButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button01")));
        WebElement buttonOne = driver.findElement(By.id("button01"));
        buttonOne.click();
    }
    public void clickOnSecondButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonTwo = driver.findElement(By.id("button02"));
        buttonTwo.click();
    }

    public void clickOnThreeButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("waitmessage")));
        WebElement buttonThree = driver.findElement(By.id("button03"));
        buttonThree.click();
    }

    @FindBy(id ="buttonmessage")
    WebElement text;

    public String displayTextAfterAllButtons() {
        return text.getText();
    }
}



