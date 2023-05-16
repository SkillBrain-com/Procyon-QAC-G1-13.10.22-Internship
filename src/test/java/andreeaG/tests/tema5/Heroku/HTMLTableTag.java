package andreeaG.tests.tema5.Heroku;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;


public class HTMLTableTag {

    public static void main(String[] args) {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get ("https://testpages.herokuapp.com/styled/tag/table.html");
        WebElement titleTextTag = driver.findElement(By.tagName("h1"));
        System.out.println("TITLE displays:  " + titleTextTag.getText());
        WebElement exampleText = driver.findElement(By.tagName("p"));
        System.out.println( "The text in italics displays  " + exampleText.getText());
        WebElement captionText = driver.findElement(By.tagName("caption"));
        System.out.println( "Top of table text is : " + captionText.getText());
        WebElement staticTable = driver.findElement(By.id("mytable"));
        List<WebElement> tableRows = driver.findElements(By.tagName("tr"));
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstRowColumns =firstRow.findElements(By.cssSelector("th"));
        System.out.println("Header1 is: " + firstRowColumns.get(0).getText());
        System.out.println("Header2 is: " + firstRowColumns.get(1).getText());
        driver.quit();
    }
}
