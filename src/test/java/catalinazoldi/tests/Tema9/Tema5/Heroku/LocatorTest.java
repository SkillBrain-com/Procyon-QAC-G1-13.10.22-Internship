package catalinazoldi.tests.Tema9.Tema5.Heroku;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class  LocatorTest {

      public static void main(String[] args) {
      locatorTest();
      }

       public static void locatorTest() {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/find-by-playground-test.html");

        WebElement firstPharagraph = driver.findElement(By.className("explanation"));
        System.out.println("Primul pharagraf are textul:" + firstPharagraph.getText());
        WebElement indexButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
        indexButton.click();
        driver.quit();
   }
}


