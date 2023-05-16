package ancaMarian.tests.tema6;

import ancaMarian.driver.BrowserManager;
import ancaMarian.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HerokuForms {

    static ChromeDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        navigateToHerokuHomePage();
        BrowserManager.maximizeWindow(driver);
        navigateToHerokuFormsPage();
        inputUsername();
        inputPassword();
        inputComment();
        addFile();
        selectCheckbox();
        deselectCheckbox();
        scrollToTheBottomOfThePage();
        selectRadioItem();
        selectFromMultipleValues();
        selectFromDropdownList();
        scrollToSubmitButton();
        FileUtils.takeScreenshot(driver, "form");
        goBackToFormPage();
        try {
            goBackToFormPage();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "ElementNotFound");
            System.out.println("Nu s-a gasit elementul pe pagina. S-a salvat un screenshot cu denumirea ElementNotFound.");
        } finally {
            BrowserManager.closeChromeDriver(driver);}
    }

    public static void navigateToHerokuHomePage(){
        driver = BrowserManager.createDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Am deschis Heroku index page.");
    }

    public static void navigateToHerokuFormsPage() {
        WebElement formsPage = driver.findElement(By.id("htmlformtest"));
        formsPage.click();
        System.out.println("Am deschis Heroku Forms page.");
    }

    public static void inputUsername(){
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Username1");
        System.out.println("Am adaugat un username.");
    }

    public static void inputPassword(){
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password1");
        System.out.println("Am adaugat o parola.");
    }

    public static void inputComment(){
        WebElement comment = driver.findElement(By.name("comments"));
        comment.clear();
        comment.sendKeys("comment1");
        System.out.println("Am adaugat un comentariu.");
    }

    public static void addFile(){
        WebElement uploadFile = driver.findElement(By.name("filename"));
        String filePath = System.getProperty("user.dir") + "/src/test/java/ancaMarian/tests/tema6/text.txt";
        uploadFile.sendKeys(filePath);
        System.out.println("Am adaugat un fisier.");
    }

    public static void selectCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[5]/td/input[1]"));
        checkbox.click();
        Thread.sleep(2000);
        System.out.println("Am selectat un checkbox.");
    }

    public static void deselectCheckbox() throws InterruptedException {
        WebElement deselectCheckbox = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[5]/td/input[3]"));
        deselectCheckbox.click();
        Thread.sleep(2000);
        System.out.println("Am deselectat un checkbox.");
    }

    public static void scrollToTheBottomOfThePage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void selectRadioItem() throws InterruptedException {
        WebElement radioItem = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[6]/td/input[1]"));
        radioItem.click();
        Thread.sleep(2000);
        System.out.println("Am selectat un radio button.");
    }

    public static void selectFromMultipleValues() throws InterruptedException {
        WebElement multipleValues = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[7]/td/select/option[2]"));
        multipleValues.click();
        Thread.sleep(2000);
        System.out.println("Am selectat a doua optiune din Multiple Select Values.");
    }

    public static void selectFromDropdownList() throws InterruptedException {
        WebElement dropdownList = driver.findElement(By.name("dropdown"));
        dropdownList.click();
        Thread.sleep(2000);
        WebElement secondElementInDropdownList = driver.findElement(By.xpath("//*[@id='HTMLFormElements']/table/tbody/tr[8]/td/select/option[2]"));
        secondElementInDropdownList.click();
    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By
                .xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre submit button");
    }

    public static void goBackToFormPage(){
        WebElement backToFormPage = driver.findElement(By.id("back_to_form"));
        backToFormPage.click();
        System.out.println("M-am intors la pagina de Form");
    }
}
