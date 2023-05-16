package bogdanSandu.tests.tema9.Tema5.DemoQa;


import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelectTextBox {

    public static void main(String[] args) {

        selectTextBox();
    }

    public static void selectTextBox() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/elements");
        WebElement textBox = driver.findElement(By.cssSelector("#item-0"));
        textBox.click();
        driver.quit();
    }
}
