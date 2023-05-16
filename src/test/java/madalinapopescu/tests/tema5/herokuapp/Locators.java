package madalinapopescu.tests.tema5.herokuapp;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {
    public static void main(String[] args) {
        goToLocators();
    }
    public static void goToLocators() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement thirdlink = driver.findElement(By.id("findbytest"));
        System.out.println("Al treilea link are textul: "+ thirdlink.getText());
        thirdlink.click();
        WebElement locatorsPageTitle = driver.findElement(By.cssSelector("div+h1"));
        System.out.println("Titlul pagini este: " + locatorsPageTitle.getText());
        WebElement locatorsPageExplanation = driver.findElement(By.className("explanation"));
        System.out.println("Explicatiile din pagina sunt: " + locatorsPageExplanation.getText());
        for (int i = 1; i < 42; i++) {
            WebElement locatorsListOfParagraphs = driver.findElement(By.id("p" + i));
            System.out.println(locatorsListOfParagraphs.getText());
        }
        for (int i = 26; i < 51; i++){
            WebElement locatorsListOfLinks = driver.findElement(By.id("a"+i));
            System.out.println(locatorsListOfLinks.getText());
        }
        driver.quit();

    }
}
