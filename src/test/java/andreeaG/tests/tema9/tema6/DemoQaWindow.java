package andreeaG.tests.tema9.tema6;


import andreeaG.driver.BrowserManager;
import andreeaG.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class DemoQaWindow {

    static RemoteWebDriver driver = null;

    public static void main(String[] args) {
        navigateToDemoQAWindowPage();
        clickOnNewTabButton();
        clickOnNewWindow();
        try {
            clickOnNewWindowMessage();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "no such element");
        } finally {
            closeBrowser();        }
    }

    public static void navigateToDemoQAWindowPage() {
        driver = BrowserManager.createRemoteWebDriver();
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
                System.out.println("Text de pe noul tab " + newTabHeading.getText());
                driver.close();
            }
        }
        //switch back to parent tab to be able to make other actions
        driver.switchTo().window(parentTab);
        System.out.println("Am facut click pe new tab button");
    }


    public static void clickOnNewWindow() {
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
                    Thread.sleep(500);
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
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newWindowMessageTab = driver.findElement(By.tagName("body"));
                System.out.println("New window message is " + newWindowMessageTab.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
        System.out.println("New window message");
    }

    public static void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed!");
    }
}

