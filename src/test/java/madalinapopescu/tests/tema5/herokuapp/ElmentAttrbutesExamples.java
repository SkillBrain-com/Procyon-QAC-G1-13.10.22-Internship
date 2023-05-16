package madalinapopescu.tests.tema5.herokuapp;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ElmentAttrbutesExamples {
    public static void main(String[] args) {
        goToElementAttributesExemples();
    }
    public static void goToElementAttributesExemples() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement secondlink = driver.findElement(By.id("elementattributestest"));
        System.out.println("Al doilea link are textul: "+ secondlink.getText());
        secondlink.click();
        WebElement atributePageExplanation = driver.findElement(By.className("explanation"));
        System.out.println("Explicatiile pe aceasta pagina sunt: " + atributePageExplanation.getText());
        WebElement atributeFirstParagraphTitle = driver.findElement(By.cssSelector("div+h2"));
        WebElement atributeFirstParagraph = driver.findElement(By.cssSelector(".inline-explanation:first-of-type"));
        System.out.println("Titlul primul paragraf este >> " + atributeFirstParagraphTitle.getText() + "! >> si contine urmatorul text >> " + atributeFirstParagraph.getText());
        WebElement atributeFirstParagraphAttributes = driver.findElement(By.cssSelector("#domattributes"));
        System.out.println("Atributul paragrafului este: " + atributeFirstParagraphAttributes.getText());
        WebElement atributeSecondParagraphTitle = driver.findElement(By.cssSelector("h2:last-of-type"));
        WebElement atributeSecondParagraph = driver.findElement(By.cssSelector(".inline-explanation:last-of-type"));
        System.out.println("Titlul celui de-al doilea paragraf este >> " + atributeSecondParagraphTitle.getText() + "! >> si contine urmatorul text >> " + atributeSecondParagraph.getText());
        WebElement atributeSecondParagraphAttributes = driver.findElement(By.cssSelector("p#jsattributes"));
        System.out.println("Atributul paragrafului 2 este: " + atributeSecondParagraphAttributes.getText());
        WebElement atributeButton = driver.findElement(By.className("styled-click-button"));
        atributeButton.click();
        WebElement wasButtonClicked = driver.findElement(By.cssSelector("[custom-1='value-1']"));
        if (wasButtonClicked.getText().equals("This paragraph has dynamic attributes")) {
            System.out.println("Butonul a fost apasat");
        }
        driver.quit();
    }
}
