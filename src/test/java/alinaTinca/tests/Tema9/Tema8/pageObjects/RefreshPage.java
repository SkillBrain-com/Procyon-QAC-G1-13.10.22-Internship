package alinatinca.tests.Tema9.Tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;

    //Create the constructor that can define the required parameters for this test case
    public RefreshPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        PageFactory.initElements(remoteWebDriver,this);
    }

    //Find the refresh button on the page
    @FindBy(id ="refreshdate")
    WebElement refreshButton;

    //Create a method that return the status for current timestamp
    public String getStatusForTimestamp(){
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("refreshdate")));
//        System.out.println("Condition has been executed!");
        return refreshButton.getText();
    }
}