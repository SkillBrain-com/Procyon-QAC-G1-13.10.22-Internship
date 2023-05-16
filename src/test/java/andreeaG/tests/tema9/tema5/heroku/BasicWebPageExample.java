package andreeaG.tests.tema9.tema5.heroku;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicWebPageExample {
    public static void main(String[] args) {
        landOnBasicWebPageExample();
    }

    public static void landOnBasicWebPageExample() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get ("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        System.out.println("First link displays:  " + firstLink.getText());
        firstLink.click();
        WebElement getFirstPara = driver.findElement(By.className("explanation"));
        System.out.println("First paragraph:  " + getFirstPara.getText());
        WebElement getMiddlePara = driver.findElement(By.id("para1"));
        System.out.println("Middle paragraph:  " + getMiddlePara.getText());
        WebElement getLastPara = driver.findElement(By.cssSelector("p#para2.sub"));
        System.out.println("First paragraph:  " + getLastPara.getText());
        WebElement bottomLink1 = driver.findElement(By.linkText("EvilTester.com"));
        bottomLink1.click();
        WebElement bottomLink2 = driver.findElement(By.linkText("Compendium Developments"));
        bottomLink2.click();
        WebElement returnToIndex = driver.findElement(By.linkText("Index"));
        returnToIndex.click();
        driver.quit();
    }
}
