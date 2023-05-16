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
public class RedirectPage {
    ChromeDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public  RedirectPage(ChromeDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='explanation']/p")
    WebElement paragraph;
    public String getParagraph(){
        return paragraph.getText();
    }
    @FindBy(id = "delaygotobasic")
    WebElement firstButton;
    public void clickOnFirstButton(){
        firstButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobasic")));
    }
    @FindBy (id = "delaygotobounce")
    WebElement secondButton;
    public void clickOnSecondButton(){
        secondButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delaygotobounce")));
    }
    @FindBy (xpath = "//div[@class='explanation']/p")
    WebElement text;
    public String displayText(){
        return text.getText();
    }
    @FindBy (id = "goback")
    WebElement goBackButton;
    public void clickOnBackButton(){
        goBackButton.click();
        System.out.println("Back to main page!");
    }
}
