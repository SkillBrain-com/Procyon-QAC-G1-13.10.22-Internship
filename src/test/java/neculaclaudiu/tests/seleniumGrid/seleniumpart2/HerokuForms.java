package neculaclaudiu.tests.seleniumGrid.seleniumpart2;

import neculaclaudiu.driver.ChromeDriverManager;
import neculaclaudiu.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class HerokuForms {
    static RemoteWebDriver driver = null;
    public static void main(String[] args){
        navigateToHerokuHomePage();
        try{
            openHtmlFormExamplePage();
            fillInputZones();
            scrollToSubmitButton();
            fillInputZones();
            clickToChooseFileButton();
            clickToAllCheckBoxItems();
            clickToAllRadioButtons();
            clickToSubmitButton();
            nonExistentElement();
        } catch (NoSuchElementException e){
            FileUtils.takeScreenshot(driver, "htmlForms");
        }finally {
            closeBrowser();
        }


    }
    public static void navigateToHerokuHomePage() {
        driver = ChromeDriverManager.createRemoteDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis index page-ul");
    }
    public static void openHtmlFormExamplePage() {
        WebElement htmlFormLink = driver.findElement(By.id("htmlformtest"));
        htmlFormLink.click();
        System.out.println("Am deschis pagina cu HTML");
    }

    public static void closeBrowser(){
        driver.quit();
        System.out.println("am inchis browser-ul");
    }
    public static void scrollToSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        System.out.println("Am dat scroll la submitButton");
    }
    public static void fillInputZones(){
        WebElement username = driver.findElement(By.cssSelector("input[name=\"username\"]"));
        username.sendKeys("claudiu357");

        WebElement password = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        password.sendKeys("11122233345667");

        WebElement comments = driver.findElement(By.cssSelector("textarea[name=\"comments\"]"));
        comments.sendKeys("Lalalalalalaalalal");
    }
    public static void clickToChooseFileButton(){
        try{
            WebElement chooseFileButton = driver.findElement(By.cssSelector("input[name=\"filename\"]"));
            chooseFileButton.sendKeys("C://path//to//file.jpg");
        }catch (InvalidArgumentException e){
            System.out.println("Am dat click pe chooseFileButton");
        }
    }
    public static void clickToAllCheckBoxItems(){
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type = \"checkbox\"]"));
        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
        }
        System.out.println("Am dat click pe toate checkBoxes");
    }
    public static void clickToAllRadioButtons(){
        List<WebElement> radioBoxes = driver.findElements(By.cssSelector("input[type = \"radio\"]"));
        for (int i = 0; i < radioBoxes.size(); i++){
            radioBoxes.get(i).click();
        }
        System.out.println("Am dat click pe toate radioBoxes");
    }
    public static void clickToSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submitButton.click();
    }
    public static void nonExistentElement(){
        WebElement nonExistent = driver.findElement(By.cssSelector("nonexistent"));
        nonExistent.click();
    }

}

