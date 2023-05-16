package alinatinca.tests.Tema9.Tema5.Demoqa.Elements;

import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;


public class Buttons {

    public static void main(String[] args) {
        goToTheButtons();
        //check if the method called goToTheButtons is done successfully

    }

    public static void goToTheButtons() {
        //create a method called goToTheButtons that goes to the Buttons sections and interacts with a button
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page setting
        remoteWebDriver.get("https://demoqa.com/buttons");
        //go to the Demoqa URL
        WebElement buttonsSection = remoteWebDriver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[5]"));
        //find the Buttons section
        buttonsSection.click();
        //click on this section
        WebElement clickMeButton = remoteWebDriver.findElement(By.xpath("//button[text()='Click Me']"));
        //find the Click Me button
        clickMeButton.click();
        //click on Click Me button
        System.out.println("This button is called: " + clickMeButton.getText());
        //display the message from this button
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}