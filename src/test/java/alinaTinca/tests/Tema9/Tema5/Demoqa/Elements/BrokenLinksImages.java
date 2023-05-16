package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;

import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrokenLinksImages {

    public static void main(String[] args) {
        goToTheBrokenLinksImages();
        //check if the method called goToTheBrokenLinksImages is done successfully
    }

    public static void goToTheBrokenLinksImages(){
        //create a method called goToTheBrokenLinksImages that goes to the Broken Links-Images section and identifies elements and make operations on them
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browse page settings
        remoteWebDriver.get("https://demoqa.com/broken");
        //get to the Demoqa URL
        WebElement brokenLinksImagesSection = remoteWebDriver.findElement(By.xpath("//div[@Class='element-list collapse show']/ul/li[7]"));
        //find the section called Broken Links Images
        JavascriptExecutor js1 = (JavascriptExecutor) remoteWebDriver;
        js1.executeScript("arguments[0].scrollIntoView();", brokenLinksImagesSection);
        //scroll to the Broken Links Images Section
        brokenLinksImagesSection.click();
        //click on this section
        WebElement lastLink = remoteWebDriver.findElement(By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']"));
        //find the last link called Broken Link
        JavascriptExecutor js2 = (JavascriptExecutor) remoteWebDriver;
        js2.executeScript("arguments[0].scrollIntoView();", lastLink);
        //scroll to the last link called Broken Link
        lastLink.click();
        //click on the last link called Broken Link
        remoteWebDriver.get("https://demoqa.com/broken");
        //go back to the main page
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}