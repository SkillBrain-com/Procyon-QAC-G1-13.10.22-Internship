package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UploadAndDownload {

    public static void main(String[] args) {
        goToTheUploadAndDownload();
        //check if the method called goToTheUploadAndDownload is done successfully
    }

    public static void goToTheUploadAndDownload(){
        //create a method called goToTheUploadAndDownload that identifies a element and makes operation on it
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://demoqa.com/upload-download");
        //go to this URL
        WebElement uploadAndDownloadSection = remoteWebDriver.findElement(By.xpath("//span[text()='Upload and Download']"));
        //find the section called Upload and Download
        JavascriptExecutor js1 = (JavascriptExecutor) remoteWebDriver;
        js1.executeScript("arguments[0].scrollIntoView();", uploadAndDownloadSection);
        //scroll to the Upload and Download Section
        uploadAndDownloadSection.click();
        //click on this button
        WebElement downloadButton = remoteWebDriver.findElement(By.cssSelector("a[id='downloadButton']"));
        //find the Download button
        Actions actions = new Actions(remoteWebDriver);
        //create an object of type Actions that takes as parameter the driver instance
        actions.moveToElement(downloadButton).build().perform();
        //scroll to the download button
        downloadButton.click();
        //click on this button
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}