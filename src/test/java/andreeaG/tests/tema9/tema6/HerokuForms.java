package andreeaG.tests.tema9.tema6;


import andreeaG.driver.BrowserManager;
import andreeaG.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HerokuForms {
    static RemoteWebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        navigateToHerokuFormsPage();
        try {
            usernameFill();
            passwordFill();
            textAreaFill();
            checkboxOneEnabling();
            checkboxTwoEnabling();
            RadioButtonClicked();
            RadioButtonLastClicked();
            multipleSelectValues();
            dropdownMenu();
            scrollToSubmitButton();
        } catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(driver, "screengrab");
            System.out.println("Printscreen done");
        } finally {
            closeBrowser();
        }
    }

    public static void navigateToHerokuFormsPage() {
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        System.out.println("Am deschis Heroku forms page!");
    }

    public static void usernameFill() {
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        userNameField.sendKeys("Tyrone");
        System.out.println("username is set.");
    }

    public static void passwordFill() {
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("Paroliciu");
        System.out.println("Password is set.");
    }

    public static void textAreaFill() {
        WebElement commentField = driver.findElement(By.xpath("//textarea[@name='comments']"));
        commentField.sendKeys("Commenting away for the comment box to get filled up");
        System.out.println("Comments are in.");
    }

    public static void checkboxOneEnabling() throws InterruptedException {
        WebElement checkboxOne = driver.findElement(By.cssSelector("input[value='cb1']"));
        checkboxOne.click();
        Thread.sleep(1000);
        System.out.println("Checkbox One is now clicked");
        if (checkboxOne.isSelected()) {
            checkboxOne.click();
        }
    }

    public static void checkboxTwoEnabling() throws InterruptedException {
        WebElement checkboxTwo = driver.findElement(By.cssSelector("input[value='cb2']"));
        checkboxTwo.click();
        Thread.sleep(1000);
        System.out.println("Checkbox Two is now clicked");
        if (checkboxTwo.isSelected()) {
            checkboxTwo.click();
        }
    }

    public static void RadioButtonClicked() {
        WebElement radioButtonOne = driver.findElement(By.cssSelector("input[value='rd1']"));
        radioButtonOne.click();
        System.out.println("Radio 1 is on!");
    }

    public static void RadioButtonLastClicked() {
        WebElement radioButtonThree = driver.findElement(By.cssSelector("input[value='rd3']"));
        radioButtonThree.click();
        System.out.println("Radio 3 is on!");
    }

    public static void multipleSelectValues() {
        WebElement multipleSelect = driver.findElement(By.name("multipleselect[]"));
        Select select = new Select(multipleSelect);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            select.selectByVisibleText(option.getText());
            System.out.println(" Multiple Select values");
        }
    }
    public static void dropdownMenu() {
        WebElement dropdown = driver.findElement(By.cssSelector("select[name='dropdown']"));
        dropdown.click();
        System.out.println("Drop down item 3");
    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();
        submitButton.click();
        System.out.println("Submit button was a success");
    }

    public static void closeBrowser() {
        driver.quit();
        System.out.println("Browser is closed!");
    }
}