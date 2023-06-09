package elizCurtnazar.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void takeScreenshot(ChromeDriver driver, String FileName) {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") +"/Logs/printScreen.png";
        try {
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            System.out.println("Nu sa putut efectua screenshotul");
            e.printStackTrace(); //afiseaza erroarea in care facem screenshot.
        }
    }

    public static void takeScreenshot1(RemoteWebDriver remoteWebDriver, String FileName) {
        File source = remoteWebDriver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") +"/Logs/printScreen.png";
        try {
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            System.out.println("Nu sa putut efectua screenshotul");
            e.printStackTrace(); //afiseaza erroarea in care facem screenshot.
        }
    }

}
