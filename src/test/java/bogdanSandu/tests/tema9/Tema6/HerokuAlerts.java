package bogdanSandu.tests.tema9.Tema6;


import bogdanSandu.driver.BrowserManager;
import bogdanSandu.utils.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class HerokuAlerts {

    static RemoteWebDriver driver;

    public static void main(String[] args) throws IOException {

        navigateToHerokuPage();
        try{
            openAlertPage();
            textFromAlertPage();
            openAlertBox();
            firstAlertText();
            acceptFirstAlert();
            openSecondAlertButton();
            secondAlertText();
            cancelSecondAlert();
            secondAlertAfterCancel();
            openThirdAlertButton();
            alertOfThirdButton();
            thirdAlertText();
            tryToFindElement();
            scrollToSubmitButton();
        }catch (NoAlertPresentException e){
            FileUtils.takeScreenshot(driver, "alert");
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "Alert");

        }finally {
            BrowserManager.closeBrowser(driver);
        }
    }

    public static void navigateToHerokuPage(){
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.manage().window().maximize();
        System.out.println("Am deschis Heroku index app!");
    }

    public static void openAlertPage(){
        WebElement alertsLink = driver.findElement(By.id("alerttest"));
        alertsLink.click();
        System.out.println("Am navigat catre alerts page!");
    }

    public static void textFromAlertPage(){
        WebElement textAlertPage = driver.findElement(By.className("explanation"));
        System.out.println("Textul din Alert Box Example: \"" + textAlertPage.getText() + "\"");
    }

    public static void openAlertBox(){
        WebElement clickFirstAlertButton = driver.findElement(By.xpath("//input[@id='alertexamples']"));
        clickFirstAlertButton.click();
        System.out.println("Am dat click pe firstSecondAlertButton!");
    }

    public static void firstAlertText(){
        Alert firstAlertText = driver.switchTo().alert();
        firstAlertText.getText();
        System.out.println("Textul alertei nr.1: \"" + firstAlertText.getText() + "\"");

    }

    public static void acceptFirstAlert(){
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        System.out.println("Am dat accept la firstAlert!");
    }

    public static void openSecondAlertButton(){
        WebElement clickSecondAlertButton =driver.findElement(By.xpath("//input[@id='confirmexample']"));
        clickSecondAlertButton.click();
        System.out.println("Am dat click pe secondAlertButton!");
    }

    public static void secondAlertText(){
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.getText();
        System.out.println("Textul alertei nr.2: \"" + secondAlert.getText() + "\"");
    }

    public static void cancelSecondAlert(){
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.dismiss();
        System.out.println("Am dat cancel la secondAlert!");
    }

    public static void secondAlertAfterCancel(){
        System.out.println("Textul dupa cancel: \"" + driver.findElement(By.id("confirmexplanation")).getText() + "\"");
    }

    public static void openThirdAlertButton(){
        WebElement clickThirdAlertButton = driver.findElement(
                By.xpath("//input[@id='promptexample']"));
        clickThirdAlertButton.click();
        System.out.println("Am dat click pe thirdAlertButton!");
    }

    public static void alertOfThirdButton(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Textul alertei nr.3: \"" + alert.getText() + "\"");
        alert.sendKeys("Text modificat");
        alert.accept();
        System.out.println("Am dat accept la alerta!");
    }

    public static void thirdAlertText(){
        System.out.println("Textul alertei nr.3: \"" + driver.findElement(By.id("promptexplanation")).getText() + "\"");
    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre submit button");
    }

    public static void tryToFindElement(){
        try {
            WebElement tryFind = driver.findElement(By.id("Boo-hoo"));
        }catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "inexistentElement");
            System.out.println("Nu exista elementul cautat!");
        }
    }
}