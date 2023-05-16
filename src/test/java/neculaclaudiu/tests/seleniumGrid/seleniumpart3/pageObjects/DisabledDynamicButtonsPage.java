package neculaclaudiu.tests.seleniumGrid.seleniumpart3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DisabledDynamicButtonsPage {

    RemoteWebDriver driver;
    WebDriverWait wait;

    public DisabledDynamicButtonsPage(RemoteWebDriver driver){
        this.driver = driver;
        this.driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "button00")
    WebElement startButton;

    @FindBy(id = "button01")
    WebElement oneButton;

    @FindBy(id = "button02")
    WebElement twoButton;

    @FindBy(id = "button03")
    WebElement threeButton;

    @FindBy(id = "buttonmessage")
    WebElement buttonMessage;

    public void clickOnStartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button00")));
        startButton.click();
    }

    public void clickOnOneButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01")));
        oneButton.click();
    }

    public void clickOnTwoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02")));
        twoButton.click();
    }

    public void clickOnThreeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03")));
        threeButton.click();
    }

    public String buttonMessageGetText(){
        return buttonMessage.getText();
    }
}
