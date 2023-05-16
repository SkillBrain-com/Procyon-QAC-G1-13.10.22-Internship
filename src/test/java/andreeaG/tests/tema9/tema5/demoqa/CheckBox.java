package andreeaG.tests.tema9.tema5.demoqa;

import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckBox {
    public static void main(String[] args) {
        goToCheckbox1();
    }

    public static void goToCheckbox1() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement checkBox = driver.findElement(By.xpath("//label/span[1]"));
        checkBox.click();
        WebElement expandPlusSign =driver.findElement(By.cssSelector(".rct-icon.rct-icon-expand-all"));
        expandPlusSign.click();
        driver.quit();
    }
}
