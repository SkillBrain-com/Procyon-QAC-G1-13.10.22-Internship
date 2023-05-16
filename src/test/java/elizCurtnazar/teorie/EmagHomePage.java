package elizCurtnazar.teorie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagHomePage {
    ChromeDriver driver;
    public EmagHomePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    //adnotari la atribute, nu la constructori si nu la metode

    @FindBy(className = "js-accept") //in loc de driver.findelemet
    WebElement acceptButton;

    public void clickOnAcceptButton() {
        acceptButton.click();
    }
}
