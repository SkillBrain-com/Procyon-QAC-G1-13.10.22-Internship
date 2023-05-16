package andreeaG.tests.tema5.Demoqa;


import andreeaG.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {

    public static void main(String[] args) {
     clickButtons();
    }

    public static void clickButtons(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();
        System.out.println("Clicked on Double Click me button and text shown is: " +doubleClickMe.getText());
        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        rightClickMe.click();
        System.out.println("Clicked on Right Click me button the text shows: " +rightClickMe.getText());
        WebElement clickMeClickMe =driver.findElement(By.xpath("//div[3]/button"));
        clickMeClickMe.click();
        // this is absolute path -WebElement clickMeClickMe = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        //clickMeClickMe.click();
        System.out.println("Clicked on  Click me button and text shown is: " +clickMeClickMe.getText());
        driver.quit();
    }
}
