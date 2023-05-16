package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadAndDownload {
    public static void main(String[] args) {
        goToTheUploadAndDownload();
        //check if the method called goToTheUploadAndDownload is done successfully
    }

    public static void goToTheUploadAndDownload(){

        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://demoqa.com/upload-download");

        WebElement uploadAndDownloadSection = driver.findElement(By.xpath("//span[text()='Upload and Download"));

        uploadAndDownloadSection.click();

        WebElement downloadButton = driver.findElement(By.cssSelector("a[id='downloadButton']"));

        downloadButton.click();

        driver.quit();

    }
}
