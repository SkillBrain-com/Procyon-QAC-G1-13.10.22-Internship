package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RadioButton {

    public static void main(String[] args) {
        goToTheRadioButton();
        //check if the method called goToTheRadioButton is done successfully
    }

    public static void goToTheRadioButton(){
        //create the method called goToTheRadioButton that goes to the section called Radio Button and it identifies one element from there and it makes operation on it
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://demoqa.com/radio-button");
        //go to the Demoqa URL
        WebElement radioButtonSection = remoteWebDriver.findElement(By.cssSelector("#item-2"));
        //find the section called Radio Button
        radioButtonSection.click();
        //click on this section
        WebElement yesRadio = remoteWebDriver.findElement(By.cssSelector("label[for='yesRadio']"));
        //find the box asignated to the field called Yes
        yesRadio.click();
        //tick this section
        System.out.println("The message displayed is: " + yesRadio.getText());
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}