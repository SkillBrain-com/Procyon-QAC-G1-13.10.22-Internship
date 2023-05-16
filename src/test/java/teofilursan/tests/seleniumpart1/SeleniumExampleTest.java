package teofilursan.tests.seleniumpart1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import teofilursan.driver.BrowserManager;


public class SeleniumExampleTest {

    public static void main(String[] args) {
        basicPageTest();
    }

    public static void basicPageTest() {
        WebDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        firstLink.click();
        System.out.println("Current url is : " + driver.getCurrentUrl());
        driver.quit();
    }
}
