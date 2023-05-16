package sorinfoca.Tests.Tema6;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sorinfoca.driver.BrowserManager;
import sorinfoca.utils.FileUtils;

import java.io.File;
import java.util.Set;

public class DemoQaWindow {
    static ChromeDriver driver = null;
    private static File screenshot;

    public static void main(String[] args) {
        navigateToDemoQaWindowPage();
        try {
            clickNewTabButton();
            interactWithElementsOnParentTab();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "window");
            System.out.println("No alert present");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToDemoQaWindowPage() {
        driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Navigated to Demo QA window page");
    }

    public static void clickNewTabButton() {
        String parentTab = driver.getWindowHandle();
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if(!tab.equals(parentTab)) {
                driver.switchTo().window(tab);
                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text on the new tab: " + newTabHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(parentTab);
    }

    public static void interactWithElementsOnParentTab() {
        WebElement clickElementButton = driver.findElement(By.id("click"));
        clickElementButton.click();
        WebElement generateAlertButton = driver.findElement(By.id("alert"));
        generateAlertButton.click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();
        WebElement switchToTabButton = driver.findElement(By.id("newTab"));
        switchToTabButton.click();
        String childTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            if(!tab.equals(childTab)) {
                driver.switchTo().window(tab);
                WebElement childTabHeading = driver.findElement(By.id("childTab"));
                System.out.println("Text on the child tab: " + childTabHeading.getText());
                driver.close();
            }
        }
        driver.switchTo().window(childTab);
        WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);
        action.moveToElement(mouseHoverButton).perform();
        WebElement mouseHoverText = driver.findElement(By.id("mousehovertext"));
        System.out.println("Mouse hover text: " + mouseHoverText.getText());
        WebElement draggableButton = driver.findElement(By.id("draggable"));
        WebElement droppableButton = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggableButton, droppableButton).build().perform();
        WebElement droppedText = driver.findElement(By.id("dropped"));
        System.out.println("Dropped text: " + droppedText.getText());
        WebElement sliderButton = driver.findElement(By.id("slider"));
        action.dragAndDropBy(sliderButton, 50, 0).build().perform();
        WebElement sliderText = driver.findElement(By.id("sliderValue"));
        System.out.println("Slider text: " + sliderText.getText());
    }
    public static void closeBrowser() {
        driver.quit();
        System.out.println("Closed browser");
    }
}

