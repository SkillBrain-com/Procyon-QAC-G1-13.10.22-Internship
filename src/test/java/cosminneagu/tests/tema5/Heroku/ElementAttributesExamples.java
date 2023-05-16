package cosminneagu.tests.tema5.Heroku;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementAttributesExamples {
    public static void main(String[] args) {
        goToElementAttributesExample();

    }

    public static void goToElementAttributesExample(){

        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement link2= driver.findElement(By.cssSelector("#elementattributestest"));

        System.out.println("The second link has the following content: " + link2.getText());

        link2.click();

        WebElement firstParagraph = driver.findElement(By.cssSelector(".explanation"));

        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());

        WebElement titleFromTheSecondParagraph = driver.findElement(By.xpath("//h2[text()='Custom Attribute and JavaScript Added']"));

        System.out.println("The title from the second paragraph has the following content: " + titleFromTheSecondParagraph.getText());

        WebElement secondParagraph = driver.findElement(By.xpath("//p[text()='The next paragraph has attributes. Some are custom attributes, and one \"original-title\" was added using JavaScript.']"));

        System.out.println("The second paragraph has the following content: " + secondParagraph.getText());

        WebElement atitleFromTheSecondParagraph= driver.findElement(By.id("domattributes"));

        System.out.println("The title located under of the second paragraph has the following content: " + atitleFromTheSecondParagraph.getText());

        WebElement titleFromTheThirdParagraph = driver.findElement(By.xpath("//h2[text()='Dynamic JavaScript Added']"));

        System.out.println("The title from the third paragraph has the following content: " + titleFromTheThirdParagraph.getText());

        WebElement thirdParagraph = driver.findElement(By.xpath("//p[text()='The next paragraph has an id, and a custom attribute called \"nextid\" which is used when adding additional attributes via JavaScript when the button is clicked e.g. \"custom-{nextid}.']"));

        System.out.println("The third paragraph has the following content: " + thirdParagraph.getText());

        WebElement lastTitle = driver.findElement(By.xpath("//p[text()='This paragraph has dynamic attributes']"));

        System.out.println("The last title is called: " + lastTitle.getText());

        WebElement greenButton = driver.findElement(By.className("styled-click-button"));

        greenButton.click();

        WebElement messageFromTheGreenButton = driver.findElement(By.xpath("//button[text()='Add Another Attribute']"));

        System.out.println("The green button has the following content: " + messageFromTheGreenButton.getText());

        driver.quit();

    }
}
