package andreeaG.tests.tema9.tema5.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import andreeaG.driver.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RadioButton {

        public static void main(String[] args) {
            radioButton();
        }

        public static void radioButton(){
            RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
            driver.get("https://demoqa.com/radio-button");
            WebElement radioButtonYes = driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='yesRadio']"));
            radioButtonYes.click();
            WebElement radioButtonImpressive =driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']"));
            radioButtonImpressive.click();
            driver.quit();
        }
    }

