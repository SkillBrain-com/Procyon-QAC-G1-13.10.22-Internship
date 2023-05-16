package elizCurtnazar.tests.tema6;

import elizCurtnazar.driver.BrowserManager;
import elizCurtnazar.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class HerokuForms {

    static ChromeDriver driver = null;

    public static void main(String[] args) throws IOException {
        navigateToHerokuFormsPage();
        inputUsername();
        inputPassword();
        inputTextAreaComment();
        chooseFile();
        checkboxItems();
//        radioItems();
        try {
            radioItems();
            System.out.println("Am intrat pe blocul de try.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Am intrat de blocul de catch");
            List <WebElement> radioButtons = driver.findElements(By.name("radioval"));
            radioButtons.get(2).click();
            System.out.println("Am ales radio 3.");
            //ALTA VARIANTA DE REZOLVARE
//            File file = driver.getScreenshotAs(OutputType.FILE);
//            File destinationFile = new File("C:\\Users\\Deniz\\IdeaProjects\\poza2.png");
//            FileUtils.copyFile(file, destinationFile);
        } finally {
            FileUtils.takeScreenshot(driver, "radio item");
            //alta varianta de rezolvare
//            File file = driver.getScreenshotAs(OutputType.FILE);
//            File destinationFile = new File("C:\\Users\\Deniz\\IdeaProjects\\poza2.png");
//            FileUtils.copyFile(file, destinationFile);
            System.out.println("Am facut screenshot de pe blocul de finally.");
            //ALTA VARIANTA DE REZOLVARE
//            driver.quit();
//            System.out.println("Am inchis browserul de pe blocul de finally.");
        }
        selectValues();
        dropdown();
        scrollSubmitButton();
        closeBrowser();
    }

    public static void navigateToHerokuFormsPage(){
        driver = BrowserManager.createDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        System.out.println("Am deschis pagina Heroku forms page");
    }

    public static void inputUsername() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input"));
        username.click();
        username.clear();
        username.sendKeys("eliz.Curtnazar");
    }

    public static void inputPassword() {
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("curtnazar91");
        System.out.println("Am adaugat password ul.");
    }

    public static void inputTextAreaComment() {
        WebElement inputComment = driver.findElement(By.name("comments"));
        inputComment.click();
        inputComment.clear();
        inputComment.sendKeys("Aceasta este tema 6.");
        System.out.println("Am adaugat un comment.");
    }

    public static void chooseFile() {
        WebElement fileUpload = driver.findElement(By.name("filename"));
        fileUpload.sendKeys(System.getProperty("user.dir") + "\\src\\test\\java\\elizCurtnazar\\tests\\tema6\\HerokuFormsFile.txt");
///        System.out.println("Am adaugat un fisier.");
    }

    public static void checkboxItems() {
        List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        System.out.println("Am ales doar checkbox 1.");
        System.out.println("Checkbox 1 is enabled: " + checkboxes.get(0).isEnabled());
    }

//    public static void radioItems() {
//        List <WebElement> radioButtons = driver.findElements(By.name("radioval"));
//        radioButtons.get(2).click();
//        System.out.println("Am ales radio 3.");
//
//    }
    public static void radioItems() {
        List <WebElement> radioButtons = driver.findElements(By.name("radival"));
        radioButtons.get(2).click();
        System.out.println("Am ales radio 3.");

}

    public static void selectValues() {
        Select selectValues = new Select(driver.findElement(By.name("multipleselect[]")));
        selectValues.selectByValue("ms1");
        selectValues.selectByValue("ms4");
        System.out.println("Am ales item 1 si item 4.");
    }

    public static void dropdown() {
        Select dropdown = new Select(driver.findElement(By.name("dropdown")));
        dropdown.selectByIndex(5);
        System.out.println("Am facut drop down item 6.");
    }

    public static void scrollSubmitButton() {
        WebElement submitButton = driver.findElement(By
                .xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre submit button si am dat click.");
    }

    public static void closeBrowser(){
        driver.quit();
        System.out.println("Am inchis browserul!");
    }
}
