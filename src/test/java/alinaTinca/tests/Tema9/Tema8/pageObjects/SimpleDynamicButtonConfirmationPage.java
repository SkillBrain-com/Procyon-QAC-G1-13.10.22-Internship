package alinatinca.tests.Tema9.Tema8.pageObjects;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleDynamicButtonConfirmationPage {

    //Create the required attributes for this test case
    RemoteWebDriver remoteWebDriver;
    WebDriverWait wait;

    //Create the constructor that can define the required parameters for this test case
    public SimpleDynamicButtonConfirmationPage(RemoteWebDriver remoteWebDriver){
        this.remoteWebDriver = remoteWebDriver;
        wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
        PageFactory.initElements(remoteWebDriver, this);
    }

    //Find the text on the page
    @FindBy(id ="buttonmessage")
    WebElement text;

    //Create a method that display the message for opening all the buttons
    public String displayTextForClickAllButtons() {
        return text.getText();
    }
}