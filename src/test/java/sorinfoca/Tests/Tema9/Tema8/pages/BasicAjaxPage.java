package sorinfoca.Tests.Tema9.Tema8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAjaxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasicAjaxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goToPage() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(By.id("combo1")));
        select.selectByVisibleText(option);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
    }

    public void clickCodeItInButton() {
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("body > div > div.centered > form > input.styled-click-button"), "value", "Code In It"));
        driver.findElement(By.name("submitbutton")).click();
    }

    public String getSelectedOption() {
        WebElement language = driver.findElement(By.id("_valuelanguage_id"));
        return language.getText();
    }

    public void selectLanguage(String option) {
        Select select = new Select(driver.findElement(By.id("combo2")));
        select.selectByVisibleText(option);
    }
}
