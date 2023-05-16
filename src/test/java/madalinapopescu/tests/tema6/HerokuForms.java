package madalinapopescu.tests.tema6;
import madalinapopescu.driver.BrowserManager;
import madalinapopescu.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
public class HerokuForms {
    static ChromeDriver driver = null;
    public static void main(String[] args) {
        navigateToHerokuFomePage();
        try{
            usernameDetails();
            passordDetails();
            commentDetails();
            fileUploadDetails();
            checkBoxesDetails();
            radioButtonsDetail();
            selectDetails();
            dropdownDetails();
            scrollToSubmitButton();
        }catch (NoSuchElementException e){
            hiddenImputDetails();
            FileUtils.takeScreenshot(driver, "hidden-imput");
            System.out.println("Am intrat in blocul de catch");
            System.out.println("Nu se poate accesa elementul ascuns");
        }finally {
            closeBrowser();
        }
    }
        public static void navigateToHerokuFomePage () {
            driver = BrowserManager.createChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
            System.out.println("Am deschis Heroku Forms page");
        }
        public static void usernameDetails () {
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys("Username-ul meu");
            System.out.println("Am introdus un usermane");
        }
        public static void passordDetails () {
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("ParolaMea");
            System.out.println("Am introdus o parola");
        }
        public static void commentDetails () {
            WebElement comment = driver.findElement(By.name("comments"));
            comment.clear();
            comment.sendKeys("Mie nu imi place sa comentez");
            System.out.println("Am introdus un comentariu");
        }
        public static void fileUploadDetails () {
            WebElement fileUpload = driver.findElement(By.name("filename"));
            fileUpload.sendKeys(System.getProperty("user.dir") + "\\src\\test\\java\\madalinapopescu\\tests\\tema6\\textTema6");
            System.out.println("Am incarcat un document text");
        }
        public static void checkBoxesDetails () {
            List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
            checkboxes.get(1).click();
            System.out.println("Am bifat un checkbox");
        }
        public static void radioButtonsDetail () {
            List<WebElement> radioButtons = driver.findElements((By.name("radioval")));
            radioButtons.get(2).click();
            System.out.println("Am selectat un radiobuton");
        }
        public static void selectDetails () {
            Select select = new Select(driver.findElement(By.name("multipleselect[]")));
            select.deselectAll();
            select.selectByValue("ms1");
            select.selectByValue("ms2");
            System.out.println("Am selectat 2 lucruri la mulplipleselect");
        }
        public static void dropdownDetails () {
            Select dropdown = new Select(driver.findElement(By.name("dropdown")));
            dropdown.selectByIndex(2);
            System.out.println("Am pus altceva la dropdown");
        }
        public static void hiddenImputDetails () {
            WebElement hiddenImput = driver.findElement(By.name("hiddenField"));
            hiddenImput.sendKeys("Acesta este un input ascuns");
        }

        public static void scrollToSubmitButton () {
            WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submitButton).build().perform();
            submitButton.click();
            FileUtils.takeScreenshot(driver, "formularul-completat");
            System.out.println("Am facut scroll catre submit button si am facut o poza");
        }
        public static void closeBrowser () {
            driver.quit();
            System.out.println("Am inchis browserul");
        }
    }

