package alinatinca.tests.Tema9.Tema6;

import alinatinca.Utils.FileUtils;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

//Ex3
public class DemoQaWindow {

    static RemoteWebDriver remoteWebDriver = null;

    public static void main(String[] args) {

    //Test1
        navigateToDemoQAWindowPage();
        clickOnNewTabButton();
        closeBrowser();

    //Test2
        navigateToDemoQAWindowPage();
        clickOnNewWindowButton();
        closeBrowser();

    //Test3
        navigateToDemoQAWindowPage();
        try{
            clickOnNewWindowMessageButton();
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(remoteWebDriver, "new alert");
        }finally {
            closeBrowser();
        }

    }

    public static void navigateToDemoQAWindowPage() {
        remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create the driver instance
        remoteWebDriver.get("https://demoqa.com/browser-windows");
        //go to Demoqa Windows page
        System.out.println("Demo QA window page has been opened!");
        //display the above message
    }

    public static void clickOnNewTabButton() {
        //get parent tab id
        String parentTab = remoteWebDriver.getWindowHandle();
        WebElement newTabButton = remoteWebDriver.findElement(By.id("tabButton"));
        //open new tab
        newTabButton.click();
        //get tab list id
        Set<String> tabs = remoteWebDriver.getWindowHandles();
        for (String tab : tabs) {
            //switch focus to new tab, get heading text and close the tab
            if (!tab.equals(parentTab)) {
                //switch focus to new tab
                remoteWebDriver.switchTo().window(tab);
                WebElement newTabHeading = remoteWebDriver.findElement(By.id("sampleHeading"));
                System.out.println("The text from new tab: " + newTabHeading.getText());
                remoteWebDriver.close();
            }
        }
        //switch back to parent tab to be able to make other actions
        remoteWebDriver.switchTo().window(parentTab);
        //switch to parent tab window
        System.out.println("Click on new tab button");
        //display the above message
    }

    public static void clickOnNewWindowButton() {
        String parentWindow = remoteWebDriver.getWindowHandle();
        //go to window which openes
        WebElement newWindowButton = remoteWebDriver.findElement(By.id("windowButton"));
        //find the New Window button from the main window
        newWindowButton.click();
        //click on New Window button
        Set<String> newTabs = remoteWebDriver.getWindowHandles();
        for (String tab : newTabs) {
            //switch focus to new tab, get heading text and close the tab
            if (!tab.equals(parentWindow)) {
                //switch focus to new tab
                remoteWebDriver.switchTo().window(tab);
                WebElement newTabtex = remoteWebDriver.findElement(By.id("sampleHeading"));
                System.out.println(newTabtex.getText());
                remoteWebDriver.close();
            }
        }
        //switch back to parent tab to be able to make other actions
        remoteWebDriver.switchTo().window(parentWindow);
        //switch to parent tab window
        System.out.println("Click on New Window button");
        //display the above message
    }

    public static void clickOnNewWindowMessageButton(){
        WebElement newWindowMessage = remoteWebDriver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();
        String parentWindow = remoteWebDriver.getWindowHandle();
        Set<String> newWindows = remoteWebDriver.getWindowHandles();
        for (String newWindow: newWindows) {
            if (!newWindow.equals(parentWindow)) {
                remoteWebDriver.switchTo().window(newWindow);
                break;
            }
        }
        //switch back to parent tab to be able to make other actions
        remoteWebDriver.switchTo().window(parentWindow);
        //switch to parent tab window
        System.out.println(remoteWebDriver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText());
        //display the above message
        remoteWebDriver.close();
        //close the current driver instance
        System.out.println("Click on New Window Message button");
        //display the above message
    }

    public static void closeBrowser() {
        remoteWebDriver.quit();
        //close the driver instance
        System.out.println("The driver instance has been closed!");
        //display the above message
    }
}