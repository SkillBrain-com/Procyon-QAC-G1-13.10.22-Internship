package neculaclaudiu.tests.seleniumGrid.seleniumpart2;

import neculaclaudiu.driver.ChromeDriverManager;
import neculaclaudiu.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class DemoQaWindow {
    static RemoteWebDriver driver = null;
    public static void main(String[] args) {
        navigateToDemoQaWindowPage();
        try {
            openNewTab();
            clickOnNewTabButton();
            clickOnNewWindow();
            clickOnNewWindowMessage();
            nonExistentElement();
        } catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "demoQaWindow");
        }finally {
            closeBrowser();
        }
    }
    public static void navigateToDemoQaWindowPage() {
        driver = ChromeDriverManager.createRemoteDriver();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Am deschis DemoQaWindowPage");
    }
    public static void openNewTab(){
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();

    }

    public static void closeBrowser(){
        driver.quit();
    }
    public static void clickOnNewTabButton(){
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for(String tab: tabs){
            if(!tab.equals(parentTab)){
                driver.switchTo().window(tab);
                WebElement newTabText = driver.findElement(By.id("sampleHeading"));
                System.out.println(newTabText.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
    }
    public static void clickOnNewWindow(){
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("windowButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs){
            if(!tab.equals(parentTab)){
                driver.switchTo().window(tab);
                WebElement newTabText = driver.findElement(By.id("sampleHeading"));
                System.out.println(newTabText.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
    }
    public static void clickOnNewWindowMessage(){
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("messageWindowButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs){
            if(!tab.equals(parentTab)){
                driver.switchTo().window(tab);
                System.out.println("Am deschis NewWindowTab");
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
    }
    public static void nonExistentElement(){
        WebElement nonExistent = driver.findElement(By.cssSelector("nonexistent"));
        nonExistent.click();
    }
}
