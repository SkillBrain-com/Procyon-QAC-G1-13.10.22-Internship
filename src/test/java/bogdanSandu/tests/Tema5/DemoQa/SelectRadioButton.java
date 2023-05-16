package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectRadioButton {

    public static void main(String[] args) {

        selectRadioButton();
    }

    public static void selectRadioButton() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/elements");
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();
        WebElement radioButtonAnswer = driver.findElement(By.cssSelector("[for='yesRadio']"));
        radioButtonAnswer.click();
        driver.quit();
    }
}
