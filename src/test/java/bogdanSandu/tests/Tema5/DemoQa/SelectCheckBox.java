package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCheckBox {

    public static void main(String[] args) {

        selectCheckBox();
    }
    public static void selectCheckBox() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
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
