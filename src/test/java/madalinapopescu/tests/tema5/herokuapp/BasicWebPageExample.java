package madalinapopescu.tests.tema5.herokuapp;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BasicWebPageExample {
    public static void main(String[] args) {
        goToBasicWebPage();}
    public static void goToBasicWebPage() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement firstlink = driver.findElement(By.id("basicpagetest"));
        System.out.println("Primul link are textul: "+ firstlink.getText());
        firstlink.click();
        WebElement pageTitle = driver.findElement(By.cssSelector("div+h1"));
        System.out.println( "Titlul pentru primul link este: " + pageTitle.getText());
        WebElement pageExplanation = driver.findElement(By.className("explanation"));
        System.out.println("Explicatiile de pe pagina sunt: " + pageExplanation.getText());
        WebElement firstParagraph = driver.findElement(By.id("para1"));
        System.out.println("Pe primul paragraf scrie: " + firstParagraph.getText());
        WebElement secondParagraph = driver.findElement(By.id("para2"));
        System.out.println("Pe al doilea paragraf scrie: " + secondParagraph.getText());
        WebElement returnToIndex = driver.findElement(By.linkText("Index"));
        returnToIndex.click();
        driver.quit();
    }
}
