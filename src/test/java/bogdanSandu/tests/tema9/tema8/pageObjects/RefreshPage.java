package bogdanSandu.tests.tema9.tema8.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefreshPage {

    private RemoteWebDriver driver;

    public RefreshPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static final String START_PAGE_URL = "https://testpages.herokuapp.com/styled/refresh";

    public static final String REFRESH_DATE_VALUE = "embeddedrefreshdatevalue";

    public static final String REFRESH_DATE = "refreshdate";

    @FindBy(id = REFRESH_DATE_VALUE)
    private WebElement refreshDateValue;

    @FindBy(id = REFRESH_DATE)
    private WebElement refreshDate;

    public WebElement getRefreshDateValue() {
        return refreshDateValue;
    }

    public String getRefreshDate() {
        return refreshDate.getText();
    }

    public void goToPage() {
        driver.get(START_PAGE_URL);
    }
}
