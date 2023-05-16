package madalinapopescu.tests.tema6;
import madalinapopescu.driver.BrowserManager;
import madalinapopescu.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class DemoQaWindow {
    static ChromeDriver driver = null;

    public static void main(String[] args) {
        navigateToDemoQAWindowPage();
        try{
            clickOnNewTabButton();
            clickOnNewWindowButton();
            clickOnNewWindowMessageButton();
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "new-message");
            System.out.println("Am intrat in blocul de catch!");
        }finally {
            closeBrowser();
        }
    }

    public static void navigateToDemoQAWindowPage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Am deschis Demo QA window page!");
    }

    public static void clickOnNewTabButton() {
        //get parent tab id
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        //open new tab
        newTabButton.click();
        //get tab list ids
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            //switch focus to new tab, get heading text and close the tab
            if (!tab.equals(parentTab)) {
                //switch focus to new tab
                driver.switchTo().window(tab);
                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text de pe noul tab: " + newTabHeading.getText());
                driver.close();
            }
        }
        //switch back to parent tab to be able to make other actions
        driver.switchTo().window(parentTab);
        System.out.println("Am facut click pe new tab button");
    }

    public static void clickOnNewWindowButton() {
        String parentTab = driver.getWindowHandle();
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        Set<String> windows = driver.getWindowHandles();
        for (String tab : windows) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text de pe noul windows: " + newTabHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("Am facut click pe new window button");
    }
    public static void clickOnNewWindowMessageButton(){
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> newWindows = driver.getWindowHandles();
        for (String newWindow: newWindows) {
            if (!newWindow.equals(parentWindow)) {
                driver.switchTo().window(newWindow);
                break;
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']")).getText());
        driver.close();
        System.out.println("Am facut click pe butonul New Window Message");
    }
        public static void closeBrowser () {
            driver.quit();
            System.out.println("Am inchis browserul!");
        }
    }
