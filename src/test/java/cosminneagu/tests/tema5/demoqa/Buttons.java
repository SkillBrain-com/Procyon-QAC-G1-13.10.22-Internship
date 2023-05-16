package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
    public static void main(String[] args) {
        goToTheButtons();

    }
    public static void goToTheButtons(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement buttonsSection = driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li[5]"));
        buttonsSection.click();
        WebElement clickMeButtons = driver.findElement(By.xpath("//button[text()='Click Me"));
        clickMeButtons.click();
        System.out.println("This button is called: " + clickMeButtons.getText());
        driver.quit();
    }
}
