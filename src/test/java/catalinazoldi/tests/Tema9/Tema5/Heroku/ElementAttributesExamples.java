package catalinazoldi.tests.Tema9.Tema5.Heroku;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElementAttributesExamples {
    public static void  main(String[] args) {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");
       WebElement findTitle = driver.findElement(By.tagName("h1"));
       System.out.println("Title displays:" + findTitle.getText());
       WebElement findSubtitle = driver.findElement(By.tagName("h2"));
       System.out.println("Subtile is:" + findSubtitle.getText());
       WebElement dynamicAttributes = driver.findElement(By.id("jsattributes"));
       System.out.println("Title is:" + dynamicAttributes.getText());
       WebElement addAnotherAttributeButton = driver.findElement(By.className("styled-click-button"));
       addAnotherAttributeButton.click();
        driver.quit();

   }
}
