package alinatinca.tests.Tema9.Tema5.Heroku;


import alinatinca.driver.BrowserManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ElementAttributesExamples {

    public static void main(String[] args) {
        goToElementAttributesExample();
        //check if the method called goToElementAttributesExample is done successfully
    }

    public static void goToElementAttributesExample(){
        //create the method called goToElementAttributesExample that goes to the link called Element Attributes Example from this URL and identifies several elements from there
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create and configure the Chrome browser page settings
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/index.html");
        //go to Heroku URL
        WebElement link2= remoteWebDriver.findElement(By.cssSelector("#elementattributestest"));
        //search the second link
        System.out.println("The second link has the following content: " + link2.getText());
        //display the message from the second link
        link2.click();
        //click on the second link
        WebElement firstParagraph = remoteWebDriver.findElement(By.cssSelector(".explanation"));
        //search the first paragraf
        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());
        //display the message from the first paragraph
        WebElement titleFromTheSecondParagraph = remoteWebDriver.findElement(By.xpath("//h2[text()='Custom Attribute and JavaScript Added']"));
        //search the title from the second paragraph
        System.out.println("The title from the second paragraph has the following content: " + titleFromTheSecondParagraph.getText());
        //display the title from the second paragraph
        WebElement secondParagraph = remoteWebDriver.findElement(By.xpath("//p[text()='The next paragraph has attributes. Some are custom attributes, and one \"original-title\" was added using JavaScript.']"));
        //search the second paragraph
        System.out.println("The second paragraph has the following content: " + secondParagraph.getText());
        //display the message from the second paragraph
        WebElement atitleFromTheSecondParagraph= remoteWebDriver.findElement(By.id("domattributes"));
        //search the title from the second paragraph
        System.out.println("The title located under of the second paragraph has the following content: " + atitleFromTheSecondParagraph.getText());
        //display the title located under of the second paragraph
        WebElement titleFromTheThirdParagraph = remoteWebDriver.findElement(By.xpath("//h2[text()='Dynamic JavaScript Added']"));
        //search the title from the third paragraph
        System.out.println("The title from the third paragraph has the following content: " + titleFromTheThirdParagraph.getText());
        //display the title from the third paragraph
        WebElement thirdParagraph = remoteWebDriver.findElement(By.xpath("//p[text()='The next paragraph has an id, and a custom attribute called \"nextid\" which is used when adding additional attributes via JavaScript when the button is clicked e.g. \"custom-{nextid}.']"));
        //search the third paragraph
        System.out.println("The third paragraph has the following content: " + thirdParagraph.getText());
        //display the message from the third paragraph
        WebElement lastTitle = remoteWebDriver.findElement(By.xpath("//p[text()='This paragraph has dynamic attributes']"));
        //search the last title
        System.out.println("The last title is called: " + lastTitle.getText());
        //display the message from the last title
        WebElement greenButton = remoteWebDriver.findElement(By.className("styled-click-button"));
        //search the green button
        greenButton.click();
        //click on the green button
        WebElement messageFromTheGreenButton = remoteWebDriver.findElement(By.xpath("//button[text()='Add Another Attribute']"));
        //search the green button
        System.out.println("The green button has the following content: " + messageFromTheGreenButton.getText());
        //display the message from the green button
        remoteWebDriver.quit();
        //close the Chrome browser page
    }
}