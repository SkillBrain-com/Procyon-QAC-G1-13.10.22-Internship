package catalinazoldi.tests.Tema9.Tema5.Heroku;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebPageExample {
    public static void main(String[] args) {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");


        WebElement firstLink = driver.findElement(By.cssSelector("a[id='basicpagetest']"));
        System.out.println("The first link has content: " + firstLink.getText());
        firstLink.click();
        WebElement firstText = driver.findElement(By.className("explanation"));
        System.out.println("First text:" + firstText.getText());
        WebElement middleParagraph = driver.findElement(By.id("para1"));
        System.out.println("Paragraph is:" + middleParagraph.getText());
        WebElement anotherParagraph = driver.findElement(By.id("para2"));
        System.out.println("Another paragraph is:" + anotherParagraph.getText());
        WebElement indexButton = driver.findElement(By.xpath("/html/body/div/div[1]/a"));
        indexButton.click();
        driver.quit();
        System.out.println("Testul a fost rulat!");
   }
 }


