package catalinazoldi.tests.Tema9.Tema5.Heroku;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Table {

       public static void main(String[] args){
           table();
       }

       public static void table() {
           RemoteWebDriver driver;
           driver = BrowserManager.createRemoteWebDriver();
           driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
           WebElement titleTableTag = driver.findElement(By.tagName("h1"));
           System.out.println("Title displays:" + titleTableTag.getText());
           WebElement exampleTable = driver.findElement(By.tagName("p"));
           System.out.println("Text displays:" + exampleTable.getText());
           WebElement captionText = driver.findElement(By.tagName("caption"));
           System.out.println("Up of table ttext is:" + captionText.getText());
           driver.quit();
        }
}
