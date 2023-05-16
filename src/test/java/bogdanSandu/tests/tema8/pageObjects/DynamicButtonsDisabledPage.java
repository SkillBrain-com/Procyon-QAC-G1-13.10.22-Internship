package bogdanSandu.tests.tema8.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static bogdanSandu.utils.WaitUtils.fluentWait;

public class DynamicButtonsDisabledPage {

    private WebDriver driver;

    public DynamicButtonsDisabledPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static final String START_PAGE_URL = "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html";

    public static final String BUTTON_START = "button00";

    public static final String BUTTON_ONE = "button01";

    public static final String BUTTON_TWO = "button02";

    public static final String BUTTON_THREE = "button03";

    public static final String MESSAGE = "buttonmessage";

    @FindBy(id = BUTTON_START)
    private WebElement startButton;

    @FindBy(id = BUTTON_ONE)
    private WebElement oneButton;

    @FindBy(id = BUTTON_TWO)
    private WebElement twoButton;

    @FindBy(id = BUTTON_THREE)
    private WebElement threeButton;

    @FindBy(id = MESSAGE)
    private WebElement message;

    public WebElement getStartButton() {
        return startButton;
    }

    public WebElement getOneButton() {
        return oneButton;
    }

    public WebElement getTwoButton() {
        return twoButton;
    }

    public WebElement getThreeButton() {
        return threeButton;
    }

    public WebElement getMessage() {
        return message;
    }

    public void goToPage() {
        driver.get(START_PAGE_URL);}

    public void clickButtons() {
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_START)));
        startButton.click();
        System.out.println("Click on start button");
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ONE)));
        oneButton.click();
        System.out.println("Click on 'One' button");
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_TWO)));
        twoButton.click();
        System.out.println("Click on 'Two' button");
        fluentWait(driver).until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_THREE)));
        threeButton.click();
        System.out.println("Click on 'Three' button");
        fluentWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id(MESSAGE)));
    }

    public void getButtonMessage() {
        System.out.println(message.getText());
    }
}
