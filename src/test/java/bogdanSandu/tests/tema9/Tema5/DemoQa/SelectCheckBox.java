package bogdanSandu.tests.tema9.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelectCheckBox {

    public static void main(String[] args) {

        selectCheckBox();
    }

    public static void selectCheckBox() {
        RemoteWebDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/elements");
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
        WebElement clickOnPlus = driver.findElement(By.cssSelector("[title='Expand all']"));
        clickOnPlus.click();
        WebElement clickOnMinus = driver.findElement(By.cssSelector("[title='Collapse all']"));
        clickOnMinus.click();
        driver.quit();
    }
}
