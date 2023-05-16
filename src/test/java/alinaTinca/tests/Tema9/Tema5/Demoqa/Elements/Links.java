package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Links {

    public static void main(String[] args) {
        goToTheLinks();
        //check if the method called goToTheLinks is done successfully
    }

    public static void goToTheLinks(){
        //create a method called goToTheLinks that find a link and it clicks on it
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://demoqa.com/links");
        //go to this URL
        WebElement linksSection = remoteWebDriver.findElement(By.xpath("//span[text()='Links']"));
        //find the Link section
        Actions actions = new Actions(remoteWebDriver);
        actions.moveToElement(linksSection).build().perform();
        //scroll to the Link section
        linksSection.click();
        //click on Link section
        WebElement createdLink = remoteWebDriver.findElement(By.partialLinkText("Created"));
        //find the third link called Created
        createdLink.click();
        //click on this link
        remoteWebDriver.get("https://demoqa.com/links");
        //go back to the main page
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}