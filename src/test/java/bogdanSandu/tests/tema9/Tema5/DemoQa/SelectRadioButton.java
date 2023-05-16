package bogdanSandu.tests.tema9.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelectRadioButton {

    public static void main(String[] args) {

        selectRadioButton();
    }

    public static void selectRadioButton() {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/elements");
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();
        WebElement radioButtonAnswer = driver.findElement(By.cssSelector("[for='yesRadio']"));
        radioButtonAnswer.click();
        driver.quit();
    }
}
