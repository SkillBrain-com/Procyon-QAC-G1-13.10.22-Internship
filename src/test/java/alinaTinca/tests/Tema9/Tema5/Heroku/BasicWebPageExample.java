package alinatinca.tests.Tema9.Tema5.Heroku;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicWebPageExample {

    public static void main(String[] args) {
        goToBasicWebPage();
        //check if the method called goToBasicWebPage is done successfully
    }

    public static void goToBasicWebPage() {
        //create a method called goToBasicWebPage that goes to the link called Basic Web Page from this URL and identifies several elements from there
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/index.html");
        //go to Heroku URL
        WebElement link1 = remoteWebDriver.findElement(By.cssSelector("a[id='basicpagetest']"));
        //search for the first link
        System.out.println("The first link has the following content: " + link1.getText());
        //display the message from the first link
        link1.click();
        //click on first link
        WebElement firstParagraph = remoteWebDriver.findElement(By.cssSelector(".explanation"));
        //search for the first paragraph
        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());
        //display the message from the second paragraph
        WebElement lastParagraph = remoteWebDriver.findElement(By.className("sub"));
        //search for last paragraph
        System.out.println("The last paragraph has the following content: " + lastParagraph.getText());
        //display the message from the last paragraph
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}