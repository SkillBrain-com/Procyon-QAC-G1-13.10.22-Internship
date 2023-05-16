package cosminneagu.tests.tema5.Heroku;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsFindByPlaygroundTestPage {
    public static void main(String[] args) {
        goToLocatorsFindByPlaygroundTestPage();

    }

    public static void goToLocatorsFindByPlaygroundTestPage(){

        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement link3 = driver.findElement(By.id("findbytest"));

        link3.click();

        WebElement firstParagraph = driver.findElement(By.className("explanation"));

        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());

        driver.quit();

    }
}
