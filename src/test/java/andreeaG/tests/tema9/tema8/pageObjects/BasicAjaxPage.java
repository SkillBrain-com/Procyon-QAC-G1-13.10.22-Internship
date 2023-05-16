package andreeaG.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasicAjaxPage {

    RemoteWebDriver driver;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public BasicAjaxPage(RemoteWebDriver driver) {
        this.driver = driver;
        //using WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //using FluentWait
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(200));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "combo1")
    WebElement category;

    @FindBy(id = "combo2")
    WebElement language;

    @FindBy(name = "submitbutton")
    WebElement submitButton;

    public void selectCategory(String categoryName) {
        Select category = new Select(this.category);
        category.selectByVisibleText(categoryName);
    }

    public void selectLanguage(String languageName) {
        //use either first option with WebDriverWait
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
        //or second option with FluentWait
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
        Select language = new Select(this.language);
        language.selectByVisibleText(languageName);
    }
    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
