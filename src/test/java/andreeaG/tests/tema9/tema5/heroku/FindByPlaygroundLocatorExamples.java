package andreeaG.tests.tema9.tema5.heroku;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FindByPlaygroundLocatorExamples {
    public static void main(String[] args) {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get ("https://testpages.herokuapp.com/styled/find-by-playground-test.html");
        WebElement findLparagraph = driver.findElement(By.id("p12"));
        System.out.println("paragraph L displays:  " + findLparagraph.getText());
        WebElement findOparagraph = driver.findElement(By.name("pName15"));
        System.out.println("paragraph O displays:  " + findOparagraph.getText());
        WebElement jumpToPara17 = driver.findElement(By.id("a43"));
        jumpToPara17.click();
        driver.quit();
    }
}
