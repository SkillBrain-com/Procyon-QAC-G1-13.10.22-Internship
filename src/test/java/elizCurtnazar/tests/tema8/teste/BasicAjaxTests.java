package elizCurtnazar.tests.tema8.teste;

import elizCurtnazar.driver.BrowserManager;
import elizCurtnazar.tests.tema8.pageObject.BasicAjaxConfirmationPage;
import elizCurtnazar.tests.tema8.pageObject.BasicAjaxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class BasicAjaxTests extends BaseTest {

    //astaarficapsvm

//    @Test
//    public void basicAjaxExample() {
//
//        driver = BrowserManager.createChromeDriverWithOptions();
//        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
//        System.out.println("Inainte " + LocalDateTime.now());
//        List<WebElement> selectCategory = driver.findElements(By.cssSelector("#combo1"));
//        selectCategory.get(0).click();
//        List <WebElement> selectLanguage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(By.name("language_id")));
//        selectLanguage.get(2).click();
//        System.out.println("Dupa " + LocalDateTime.now());
//        WebElement codeInItButton = driver.findElement(By.cssSelector(".styled-click-button"));
//        codeInItButton.click();
//        Assert.assertEquals(driver.getCurrentUrl(),
//                "https://testpages.herokuapp.com/styled/the_form_processor.php?ajax=1",
//                "The input data is not displayed!");
//        driver.quit();
//    }

    @Test(groups = {"mobile","desktop"})
    public void codeItInTest() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver); //initializez obiect
        basicAjaxPage.selectCategory("Desktop");
        basicAjaxPage.selectLanguage("Assembler");
        basicAjaxPage.clickOnSubmitButton();
        BasicAjaxConfirmationPage basicAjaxConfirmationPage = new BasicAjaxConfirmationPage(driver); //initializez al doilea obiect
        Assert.assertEquals(basicAjaxConfirmationPage.getCategoryText(), "2");
        System.out.println(basicAjaxConfirmationPage.getCategoryText());
    }

    @Test(groups = {"mobile","desktop"})
    public void codeInItTest2() {
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");
        BasicAjaxPage basicAjaxPage = new BasicAjaxPage(driver);
        basicAjaxPage.selectCategory("Web");
        basicAjaxPage.selectLanguage("Flash");
        basicAjaxPage.clickOnSubmitButton();
        BasicAjaxConfirmationPage basicAjaxConfirmationPage = new BasicAjaxConfirmationPage(driver);
        System.out.println(basicAjaxConfirmationPage.getLanguageType());
        Assert.assertEquals(basicAjaxConfirmationPage.getCategoryText(), "1");
        Assert.assertEquals(basicAjaxConfirmationPage.getLanguageType(), "3");
    }
}

