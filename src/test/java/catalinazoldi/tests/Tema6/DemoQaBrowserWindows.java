package catalinazoldi.tests.Tema6;

import catalinazoldi.driver.BrowserManager;
import catalinazoldi.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.Set;

public class DemoQaBrowserWindows {
    static ChromeDriver driver = null;


    public static void main(String[] args) {
        goToDemoQaPage();
        clickOnNewTabButton();
        clickOnNewWindow();
        try {
            clickOnNewWindowMessage();
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver,"window message");
        }finally{
            closeBrowser();
        }
    }

    public static void goToDemoQaPage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Am deschis DemoQa page.");
    }

    public static void clickOnNewTabButton() {


        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (
                String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Textul este:" + newTabHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("Click pe butonul New Tab");
    }

         public static void closeBrowser(){
          driver.quit();
       System.out.println("Am inchis browserul.");
       }
     public static void clickOnNewWindow(){
         //get parent tab id
         String parentTab = driver.getWindowHandle();
         WebElement newTabButton = driver.findElement(By.id("windowButton"));
         //open new tab
         newTabButton.click();
         //get tab list ids
         Set<String> tabsOne = driver.getWindowHandles();
         for (String tab : tabsOne) {
             //switch focus to new tab, get heading text and close the tab
                if (!tab.equals(parentTab)) {
                    //switch focus to new tab
                 driver.switchTo().window(tab);
                 WebElement newWindowHeading = driver.findElement(By.id("sampleHeading"));
                 try {
                     Thread.sleep(200);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 System.out.println("Text on New Window: " + newWindowHeading.getText());
                 driver.close();
             }
     }
         //switch back to parent tab to be able to make other actions
         driver.switchTo().window(parentTab);
         System.out.println("New Window has opened up");
     }
    public static void clickOnNewWindowMessage() {
        String parentTab = driver.getWindowHandle();
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newWindowHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Textul din New Window Message este:" + newWindowHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("Am facut click pe butonul New Window Message");
    }
}


