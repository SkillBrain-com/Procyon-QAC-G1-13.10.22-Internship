package bogdanSandu.tests.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static bogdanSandu.utils.WaitUtils.fluentWait;

public class BasicAjaxPage {

    private WebDriver driver;

    public BasicAjaxPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static final String START_PAGE_URL = "https://testpages.herokuapp.com/styled/basic-ajax-test.html";

    @FindBy(css ="#combo1")
    private WebElement selectCategory;

    @FindBy(css ="#combo2")
    private WebElement selectLanguage;

    @FindBy(css ="input.styled-click-button")
    private WebElement button;

    @FindBy(id ="_valueid")
    private WebElement categorySelected;

    @FindBy(id ="_valuelanguage_id")
    private WebElement languageSelected ;

    public void goToPage() {
        driver.get(START_PAGE_URL);
    }

    public void clickOnButton(){
        button.click();
        fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueid")));
        Assert.assertEquals(driver.getCurrentUrl(),"https://testpages.herokuapp.com/styled/the_form_processor.php?ajax=1");
    }

    public void selectCategory(int categoryValue) {
        Select category = new Select(selectCategory);
        category.selectByIndex(categoryValue);
        fluentWait(driver).until(ExpectedConditions.titleIs("Test Page For Basic Ajax Example"));
    }

    public void selectLanguage(int languageValue) {
        Select language= new Select(selectLanguage);
        language.selectByIndex(languageValue);
    }
}
