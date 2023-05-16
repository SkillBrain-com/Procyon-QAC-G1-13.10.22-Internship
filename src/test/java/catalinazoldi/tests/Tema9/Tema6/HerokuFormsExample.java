package catalinazoldi.tests.Tema9.Tema6;

import catalinazoldi.utils.FileUtils;
import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HerokuFormsExample {
    static ChromeDriver driver = null;

    public static void main(String[] args) {
        navigateToHerokuPage();
        try{
            openFormExamplePage();
            basicFormElements();
            scrollToSubmitButton();
            FileUtils.takeScreenshot(driver, "alertForms");
        }catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "Forms");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuPage() {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        System.out.println("Heroku page a fost deschisa! ");
    }

    public static void openFormExamplePage() {
        WebElement alertsLink = driver.findElement(By.xpath("//*[@id=\"htmlformtest\"]"));
        alertsLink.click();
        System.out.println("Pagina de alerte a fost deschisa!");
    }

    public static void basicFormElements() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Lala");
        System.out.println("Am completat la:" + "\"Username\"");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("passwordLala");
        System.out.println("Am completat la:" + "\"Password\"");
        WebElement comment = driver.findElement(By.name("comment"));
        System.out.println("Am completat la:" + "\"TextArea Comment\"");
        List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
        checkboxes.get(2).click();
        System.out.println("Am selectat la:" + "\"CheckBoxItems\"");
        List<WebElement> radioButton = driver.findElements(By.name("radioval"));
        radioButton.get(3).click();
        System.out.println("Am selecetat la " + "\"Radio Items\"");
        Select select = new Select(driver.findElement(By.name("multiselect[]")));
        select.selectByValue("ms3");
        select.selectByValue("ms4");
        System.out.println("Am selecetat la " + "\"Multiple Select Values\"");
        Select dropdown = new Select(driver.findElement(By.name("dropdown")));
        dropdown.selectByIndex(5);
        System.out.println("Am selecetat la " + "\"Dropdown\"");

    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Am facut scroll catre submit button");
    }

        public  static void closeBrowser() {
            driver.quit();
            System.out.println("Am inchis browserul!");
        }
}
