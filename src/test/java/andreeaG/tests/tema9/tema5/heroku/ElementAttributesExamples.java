package andreeaG.tests.tema9.tema5.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import andreeaG.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElementAttributesExamples {
    public static void main(String[] args) {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");
        WebElement findTitle = driver.findElement(By.tagName("h1"));
        System.out.println("Title displays  " + findTitle.getText());
        WebElement findSubtitle = driver.findElement(By.tagName("h2"));
        System.out.println("Subtitle is " + findSubtitle.getText());
        WebElement centreParagraph = driver.findElement(By.id("domattributes"));
        System.out.println("Text displayed in centre paragraph is: " + centreParagraph.getText());
        WebElement nextParagraphTitle = driver.findElement(By.xpath("/html/body/div/h2[2]"));
        System.out.println("Title is " + nextParagraphTitle.getText());
        WebElement nextIdParagraph = driver.findElement(By.className("inline-explanation"));
        System.out.println("Paragraph displays: " + nextIdParagraph.getText());
        WebElement dynamicAttributes = driver.findElement(By.id("jsattributes"));
        System.out.println("Title is " + dynamicAttributes.getText());
        WebElement addAnthrAttributeGreenbtn = driver.findElement(By.className("styled-click-button"));
        addAnthrAttributeGreenbtn.click();
        driver.quit();
    }
}
