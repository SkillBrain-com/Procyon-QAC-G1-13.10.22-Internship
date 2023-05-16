package cosminneagu.tests.tema5.Heroku;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebPageExample {

    public static void main(String[] args) {
        goToBasicWebPage();

    }

    public static void goToBasicWebPage() {

        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement link1 = driver.findElement(By.cssSelector("a[id='basicpagetest']"));
        System.out.println("The first link has the following content: " + link1.getText());
        link1.click();
        WebElement firstParagraph = driver.findElement(By.cssSelector(".explanation"));
        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());
        WebElement lastParagraph = driver.findElement(By.className("sub"));
        System.out.println("The last paragraph has the following content: " + lastParagraph.getText());
        driver.quit();

    }
}
