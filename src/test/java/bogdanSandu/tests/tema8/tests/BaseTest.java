package bogdanSandu.tests.tema8.tests;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ChromeDriver driver = null;

    @BeforeMethod(onlyForGroups = {"Desktop"})
    public void beforeMethodWithLogin() {
        driver = BrowserManager.getChromeDriverForDesktop();
    }

    @BeforeMethod(onlyForGroups = {"Mobile"})
    public void beforeMethodWithoutLogin() {
        driver = BrowserManager.getChromedriverForMobile();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected boolean isElementPresent(By locator){
        try{
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
