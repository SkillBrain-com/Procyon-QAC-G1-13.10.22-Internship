package neculaclaudiu.tests.seleniumpart3.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAjaxPage {

    ChromeDriver driver;
    WebDriverWait wait;

    public BasicAjaxPage(ChromeDriver driver){
        this.driver = driver;
        this.driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "combo1")
    WebElement category;

    @FindBy(id = "combo2")
    WebElement language;

    @FindBy(className = "styled-click-button")
    WebElement codeInButton;

    public void selectCategory(String categoryName){
        Select category = new Select(this.category);
        category.selectByVisibleText(categoryName);
    }

    public void selectLanguage(String languageName){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
        Select language = new Select(this.language);
        language.selectByVisibleText(languageName);
    }

    public void clickOnCodeInButton(){
        codeInButton.click();
    }

}
