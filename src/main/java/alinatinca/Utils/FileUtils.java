package alinatinca.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void takeScreenshot(RemoteWebDriver remoteWebDriver, String fileName) {
        File source = remoteWebDriver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + String.format("/Logs/%s.png", fileName);
        try {
            org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            System.out.println("The screenshot could not be done");
            e.printStackTrace();
        }
    }
}