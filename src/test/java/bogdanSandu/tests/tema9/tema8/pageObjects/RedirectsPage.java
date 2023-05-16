package bogdanSandu.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static bogdanSandu.utils.WaitUtils.fluentWait;
import static org.testng.Assert.assertEquals;

public class RedirectsPage {

    private RemoteWebDriver driver;

    String expectedURL = "https://testpages.herokuapp.com/styled/javascript-redirect-test.html";

    public RedirectsPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static final String START_PAGE_URL = "https://testpages.herokuapp.com/styled/javascript-redirect-test.html";

    public static final String DELAY_BOUNCE = "delaygotobounce";

    public static final String BACK_BUTTON = "goback";

    public static final String DELAY_BASIC = "delaygotobasic";

    @FindBy(id= DELAY_BASIC)
    private WebElement delayBasic;

    @FindBy(id= BACK_BUTTON)
    private WebElement backButton;

    @FindBy(id= DELAY_BOUNCE)
    private WebElement delayBounceBtn;


    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getDelayBounceButton() {
        return delayBounceBtn;
    }

    public void goToPage() {
        driver.get(START_PAGE_URL);
    }

    public void clickDelayBasicButton() {
        delayBasic.click();
        fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id(BACK_BUTTON)));

    }

    public void clickDelayBounceButton(){
        delayBounceBtn.click();
        fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id(BACK_BUTTON)));
    }

    public void backButton() {
        backButton.click();
        fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id(DELAY_BOUNCE)));
        assertEquals(expectedURL, driver.getCurrentUrl(),"Not redirected to the correct page after pressing the delay basic button");
    }
}