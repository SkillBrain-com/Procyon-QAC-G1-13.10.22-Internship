package andreeaG.tests.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPage {

    ChromeDriver driver;
    WebDriverWait wait;

    public RefreshPage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(19));
        PageFactory.initElements(driver, this);
    }

    @FindBy (id="refreshdate")
    WebElement refresh;
    public String firstTimestamp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshdate")));
        return refresh.getText();
    }


   /*@FindBy (id="refreshdisplay")
    WebElement refreshdisplay;
    public String afterRefreshTimestamp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshdisplay")));
        return refreshdisplay.getText();
    } */
}
