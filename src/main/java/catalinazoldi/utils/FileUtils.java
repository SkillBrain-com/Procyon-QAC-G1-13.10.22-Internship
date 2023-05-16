package catalinazoldi.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void takeScreenshot(ChromeDriver driver, String FileName){
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/Logs/printScreen.png";
        try{
            org.apache.commons.io.FileUtils.copyFile(source,new File(destinationFile));
        } catch (IOException e) {
            System.out.println("Screenshotul nu s-a putut efectua");
            e.printStackTrace();
        }
    }
}
