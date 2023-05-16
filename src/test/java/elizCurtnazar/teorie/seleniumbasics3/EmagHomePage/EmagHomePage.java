package elizCurtnazar.teorie.seleniumbasics3.EmagHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class EmagHomePage {

    //initializam selenium basics 3
    ChromeDriver driver;

    //initalizam selenium grid
    RemoteWebDriver remoteWebDriver; //pentru tema selenium grid
    public EmagHomePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public EmagHomePage(RemoteWebDriver driver) {  //selenium grid  RemoteWebDriver//
        this.remoteWebDriver = driver;
        PageFactory.initElements(driver, this);
    }


 //adnotari la atribute, nu la constructori si nu la metode

    @FindBy(className = "js-accept") //in loc de driver.findelemet
    WebElement acceptButton;

    public void clickOnAcceptButton() {
        acceptButton.click();
    }

}
