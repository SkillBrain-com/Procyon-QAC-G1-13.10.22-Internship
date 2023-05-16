package cosminneagu.teorie.seleniumbasicspart2;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumExceptions {

    public static void main(String[] args) {
        //noSuchElementException();
        System.out.println("Am executat cu succes functia main.");
    }

    static void noSuchElementException() {
        ChromeDriver driver = null;
        try {
            driver = BrowserManager.createChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/index.html");
            WebElement firstLink = driver.findElement(By.id("baicpagetest"));
            firstLink.click();
        } catch (NoSuchElementException e) {
            System.out.println("Nu s-a gasit elementul: " + e.getMessage());
            WebElement firstLink = driver.findElement(By.id("basicpagetest"));
            firstLink.click();
        } finally {
            if (driver!=null) {
                driver.quit();
            }
        }
    }
}
