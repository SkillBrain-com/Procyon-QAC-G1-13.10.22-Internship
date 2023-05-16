package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;

import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckBox {

    public static void main(String[] args) {
        goToTheCheckBox();
        //check if the method called goToChechBox is done successfully
    }
    public static void goToTheCheckBox(){
        //create a method called goToTheCheckBox that goes to this section and idetifies one element and make operation on it
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chome browser page settings
        remoteWebDriver.get("https://demoqa.com/checkbox");
        //go to the Demoaq URL
        WebElement checkBoxSection = remoteWebDriver.findElement(By.xpath("//span[text()='Check Box']"));
        //find the section called Check Box
        checkBoxSection.click();
        //click on the Check Box section
        WebElement checkBox = remoteWebDriver.findElement(By.cssSelector(".rct-checkbox svg[stroke='currentColor']"));
        //find the box asignated to the field called Home
        checkBox.click();
        //click on that box
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}