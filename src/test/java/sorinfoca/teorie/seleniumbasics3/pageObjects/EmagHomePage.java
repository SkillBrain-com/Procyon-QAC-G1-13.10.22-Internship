package sorinfoca.teorie.seleniumbasics3.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage {

 //   ChromeDriver driver;
// teorie selenium basics 3
    // for teorie selenium grid

    ChromeDriver driver;
    RemoteWebDriver remoteWebDriver;

    public EmagHomePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmagHomePage(RemoteWebDriver driver) {
        this.remoteWebDriver = driver;
        PageFactory.initElements(driver, this);
    }
    //WebElement acceptButton = driver.findElement(By.className("js-accept"))
    @FindBy(className = "js-accept")
    WebElement acceptButton;

    public void clickOnAcceptButton() {
        acceptButton.click();
    }
}
