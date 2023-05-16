package ioanandroflorea.tests.Tema9.tema5;

import ioanandroflorea.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class HerokuAppTests {
    public static void main(String[] args) {
        goToBasicWebPageAndCheckElements();
        elementAttributesExample();
        locatorsFindByPage();
        tableTestPage();
    }

    public static void goToBasicWebPageAndCheckElements() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        System.out.println("Primul link are textul: " + firstLink.getText());
        firstLink.click();
        WebElement lastParagraph = driver.findElement(By.className("sub"));
        System.out.println("Ultimul paragraph are textul: " + lastParagraph.getText());
        driver.quit();
    }
    public static void elementAttributesExample(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondLink = driver.findElement(By.xpath("//div[@class='page-navigation']//a"));
        secondLink.click();
        System.out.println("Next-id after click is: "+ secondLink.getAttribute("nextid"));
        driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        secondLink = driver.findElement(By.id("jsattributes"));
        System.out.println("Primul link are textul: " + secondLink.getText());
        driver.quit();
    }

    public static void locatorsFindByPage(){
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement thirdLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        thirdLink.click();
        System.out.println("Al treilea link are textul: " + thirdLink.getText());
        WebElement firstParagraph = driver.findElement(By.className("explanation "));
        System.out.println("Primul paragraf are textul: " + firstParagraph.getText());
        driver.quit();
    }

    public static void tableTestPage() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement tableLink = driver.findElement(By.id("tablestest"));
        System.out.println("Primul link are textul: " + tableLink.getText());
        tableLink.click();
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> firstColumns = rows.get(0).findElements(By.tagName("td"));
        for(WebElement row:rows) {
            System.out.println(row.findElements(By.tagName("td")));}
        driver.quit();
    }
}

