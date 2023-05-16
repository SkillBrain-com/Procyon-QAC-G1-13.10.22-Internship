package madalinapopescu.tests.tema5.demoqa;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class RadioButton {
    public static void main(String[] args) {
        goToRadioButton();
    }
    public static void goToRadioButton(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement radioButton = driver.findElement(By.cssSelector("#item-2"));
        radioButton.click();
        WebElement yesButton = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        yesButton.click();
        System.out.println("Mesajul afisat este: " + yesButton.getText());
        driver.quit();
    }
}
