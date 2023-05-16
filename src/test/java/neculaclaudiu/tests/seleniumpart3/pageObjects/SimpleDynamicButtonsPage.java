package neculaclaudiu.tests.seleniumpart3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleDynamicButtonsPage {

    ChromeDriver driver;
    WebDriverWait wait;

    public SimpleDynamicButtonsPage(ChromeDriver driver){
        this.driver = driver;
        this.driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");
        wait = new WebDriverWait(driver , Duration.ofSeconds(5));
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
