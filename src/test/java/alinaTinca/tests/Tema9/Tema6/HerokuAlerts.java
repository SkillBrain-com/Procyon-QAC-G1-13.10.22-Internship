package alinatinca.tests.Tema9.Tema6;

import alinatinca.Utils.FileUtils;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

import static alinatinca.tests.Tema9.Tema6.DemoQaWindow.remoteWebDriver;

//EX1
public class HerokuAlerts {

    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException {

    //Test1
        navigateToHerokuHomePage();
        openAlertsPage();
        firstParagraph();
        getInstructionsForAlertButtons();
        closeBrowser();

    //Test2
        navigateToHerokuHomePage();
        openAlertsPage();
        openAlertForFirstButton();
        acceptAlert();
        openAlertForSecondButton();
        dismissAlert();
        openAlertForThirdButton();
        dismissAlert();
        closeBrowser();

    //Test3
        navigateToHerokuHomePage();
        //go to Heroku Home Page
        try{
            openAlertForFirstButton();
          //go to the first alert button and identify the exception
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(remoteWebDriver, "Alert for the first button");
          //call this method and take a screenshot for exception with the above message
            System.out.println("It should take a screenshot for the exception identified");
          //display the above message
        } finally {
            closeBrowser();
            //close the driver instance
        }

    //Test4
        navigateToHerokuHomePage();
        //go to the second alert button
        try{
            openAlertForSecondButton();
            //go to the second alert button and identify the exception
        }catch(NoSuchElementException e){
           FileUtils.takeScreenshot(remoteWebDriver, "Alert for the second button");
            //call this method and take the screenshot for exception with the above message
           System.out.println("It should take a screenshot for the exception identified");
            //display the above message
        }finally {
            closeBrowser();
            //close the driver instance
        }

    //Test5
        navigateToHerokuHomePage();
        //go to the third alert button
        try{
            openAlertForThirdButton();
            //go to the third alert button and identify the exception
        } catch (NoSuchElementException e){
            FileUtils.takeScreenshot(remoteWebDriver, "Alert for the third button");
            //call this method and take the screenshot for exception with the above message
            System.out.println("It should take a screenshot for the exception identified");
            //display the above message
        }finally {
            closeBrowser();
            //close the driver instance
        }
    }

    public static void navigateToHerokuHomePage() {
        remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create the driver instance
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/index.html");
        //go to the above URL
        System.out.println("Heroku index page has been opened!");
        //display the above message
    }

    public static void openAlertsPage(){
        WebElement alertsLink = remoteWebDriver.findElement(By.id("alerttest"));
        //find the alerts page
        alertsLink.click();
        //click on the alerts page
        System.out.println("The alerts page has been opened!");
        //display the above message
    }

    public static void firstParagraph() {
        WebElement firstParagraph = remoteWebDriver.findElement(By.className("explanation"));
        //find the first paragraph
        System.out.println("The first paragraph has the following message: " + firstParagraph.getText());
        //display the message for the first paragraph
    }

    public static void getInstructionsForAlertButtons() {
        WebElement messageForFirstAlertButton = remoteWebDriver.findElement(By.xpath("//*[contains(text(),'The following button will display an alert when clicked.')]"));
        //find the instruction for the first alert button
        System.out.println("Some instructions about the three alerts on the page will follow: ");
        //display the above message
        System.out.println("The first alert button has the following instruction: " + messageForFirstAlertButton.getText());
        //display the instruction for the first alert button
        WebElement messageForSecondAlertButton = remoteWebDriver.findElement(By.xpath("//*[contains(text(),'The following button will display a confirm dialog when clicked.')]"));
        //find the instruction for the second alert button
        System.out.println("The second alert button has the following instruction: " + messageForSecondAlertButton.getText());
        //display the instruction for the first alert button
        WebElement messageForThirdAlertButton = remoteWebDriver.findElement(By.xpath("//*[contains(text(),'The following button will display a prompt dialog when clicked.')]"));
        //find the instruction for the second alert button
        System.out.println("The third alert button has the following instruction: " + messageForThirdAlertButton.getText());
        //display the instruction for the first alert button
    }

    public static void openAlertForFirstButton() {
        WebElement firstAlertButton = remoteWebDriver.findElement(By.id("alertexamples"));
        //find the first alert button
        firstAlertButton.click();
        //click on the first alert button
        System.out.println("Click on the first alert button");
        //display the above message
        Alert firstAlert = remoteWebDriver.switchTo().alert();
        //create the alert for the first alert and switch to it
        System.out.println("The message displayed after opening the alert: " +firstAlert.getText());
        //show the message after opening the alert
    }

    public static void acceptAlert() {
        Alert firstAlert = remoteWebDriver.switchTo().alert();
        //create the alert for the first alert and switch to it
        firstAlert.accept();
        //click on OK button when the alert is opened
        System.out.println("The alert has been accepted!");
        //The alert has been accepted
    }

    public static void openAlertForSecondButton () {
        WebElement secondAlertButton = remoteWebDriver.findElement(By.id("confirmexample"));
        //find the second alert button
        secondAlertButton.click();
        //click on the second alert button
        System.out.println("Click on the second alert button");
        //display the above message
        Alert secondAlert = remoteWebDriver.switchTo().alert();
        //create the alert for the second alert and switch to it
        System.out.println("The message displayed after opening the alert: " +secondAlert.getText());
        //show the message after opening the alert
    }

   public static void dismissAlert () {
        Alert dismissAlert = remoteWebDriver.switchTo().alert();
        //create the alert and switch to it
        dismissAlert.dismiss();
        //click on Cancel button when the alert is opened
        System.out.println("The alert has been dissmised!");
        //The alert has been dissmised
   }

    public static void openAlertForThirdButton () {
        WebElement thirdAlertButton = remoteWebDriver.findElement(By.id("promptexample"));
        //find the third alert button
        Actions actions = new Actions(remoteWebDriver);
        actions.moveToElement(thirdAlertButton).build().perform();
        //scroll to the third alert button
        thirdAlertButton.click();
        //click on the third alert button
        System.out.println("Click on the third alert button");
        //display the above message
        Alert thirdAlert = remoteWebDriver.switchTo().alert();
        //create the alert for the third alert and switch to it
        System.out.println("The message displayed after opening the alert: " + thirdAlert.getText());
        //show the message after opening the alert
    }

    public static void closeBrowser(){
        remoteWebDriver.quit();
        //close the driver instance
        System.out.println("The driver instance has been closed!");
        //display the above message
    }
}