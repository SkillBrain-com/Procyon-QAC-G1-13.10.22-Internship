package neculaclaudiu.tests.seleniumpart3.pageObjects;

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

    public RefreshPage(ChromeDriver driver){
        this.driver = driver;
        this.driver.get("https://testpages.herokuapp.com/styled/refresh");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "refreshdate")
    WebElement refreshNumber;

    public String getRefreshNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshdate")));
        return refreshNumber.getText();
    }
}
