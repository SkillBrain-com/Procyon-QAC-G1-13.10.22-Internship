package bogdanSandu.tests.Tema5.DemoQa;


import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTextBox {

    public static void main(String[] args) {

        selectTextBox();
    }

    public static void selectTextBox() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/elements");
        WebElement textBox = driver.findElement(By.cssSelector("#item-0"));
        textBox.click();
        driver.quit();
    }
}
