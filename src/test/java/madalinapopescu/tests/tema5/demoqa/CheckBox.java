package madalinapopescu.tests.tema5.demoqa;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CheckBox {
    public static void main(String[] args) {
        goToCheckBox();
    }
    public static void goToCheckBox(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]/span"));
        checkBox.click();
        WebElement selectHome = driver.findElement(By.cssSelector(".rct-checkbox svg[stroke='currentColor']"));
        selectHome.click();
        driver.quit();
    }
}
