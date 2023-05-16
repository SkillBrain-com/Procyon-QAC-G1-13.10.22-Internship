package madalinapopescu.tests.tema8.pageobjects;

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

public class DisabledDynamicButtonPage {
    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public DisabledDynamicButtonPage(ChromeDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="button00")
    WebElement startButton;
    public void clickOnStartButton(){
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("button00")));
        startButton.click();
    }
    @FindBy(id="button01")
    WebElement oneButton;
    public void clickOnOneButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
        oneButton.click();
    }
    @FindBy(id = "button02")
    WebElement secondButton;
    public void clickOnSecondButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02")));
        secondButton.click();
    }
    @FindBy(id="button03")
    WebElement thirdButton;
    public void clickOnThirdButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03")));
        thirdButton.click();
    }
    @FindBy(id="buttonmessage")
    WebElement text;
    public String textForClickAllButtons(){
        return text.getText();
    }
}
