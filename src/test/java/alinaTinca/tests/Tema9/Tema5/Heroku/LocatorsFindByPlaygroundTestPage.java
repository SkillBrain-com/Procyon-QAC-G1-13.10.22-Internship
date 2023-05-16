package alinatinca.tests.Tema9.Tema5.Heroku;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LocatorsFindByPlaygroundTestPage {

    public static void main(String[] args) {
        goToLocatorsFindByPlaygroundTestPage();
        //check if the method called goToLocatorsFindPlaygroundTestPage is done successfully
    }

    public static void goToLocatorsFindByPlaygroundTestPage(){
        //create the method called goToLocatorsFindPlaygroundTestPage that goes to the link called Locators - Find By Playground Test Page from this URL and identifies several elements from there
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/index.html");
        //go to Heroku URL
        WebElement link3 = remoteWebDriver.findElement(By.id("findbytest"));
        //search the third link
        link3.click();
        //click on the third link
        WebElement firstParagraph = remoteWebDriver.findElement(By.className("explanation"));
        //search the first paragraph
        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());
        //display the message from the first paragraph
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}