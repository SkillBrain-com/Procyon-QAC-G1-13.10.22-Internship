package elizCurtnazar.tests.tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestPagesHerokuappManager {
    //atribute
    private String url; //pagina la care lucram
    private static ChromeDriver driver = null; //salvam instanta de chrome pe care o vom folosi in toate metodele de clasa

    //constructori

    public TestPagesHerokuappManager(String url, ChromeDriver driver){
        this.url = url;
        this.driver = driver;
        driver.get(url);

        //  driver.close(); //inchide doar tabul in care ne aflam
        // driver.quit(); //inchide toata sesiune de chrome
    }

    //referentiem un obiect cu WebElement si instantiem cu metododa driver.findElement

    public static void goToTheFirstPage(){

        WebElement firstPage = driver.findElement(By.linkText("Basic Web Page Example"));
        firstPage.click();
        System.out.println("Am acessat primul link.");
        WebElement Paragraph = driver.findElement(By.className("explanation")); //cssselector(div.explanation p)
        Paragraph.getText();
        System.out.println(Paragraph.getText());
        driver.navigate().back();
        System.out.println("M-am intors la pagina initiala");

    }

    public static void goToTheSecondPage() {
        WebElement secondPage = driver.findElement(By.linkText("Element Attributes Examples"));
        secondPage.click();
        System.out.println("Am accesat al doilea link");
        WebElement button = driver.findElement(By.cssSelector("div.centered button"));
        button.click();
        System.out.println("Am dat click pe Add Another Attribute");
        driver.navigate().back();
        System.out.println("M-am reintors pe pagina initiala");
    }

    public static void goToTheThirdPage() {
        WebElement thirdPage = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        thirdPage.click();
        System.out.println("Am accesat al treila link ");
        WebElement pageParagraph = driver.findElement(By.className("explanation"));
        pageParagraph.getText();
        System.out.println(pageParagraph.getText());
        driver.navigate().back();
        System.out.println("M-am reintors la pagina initiala");
    }

    public static void goToTheFourthPage() {
        WebElement fourthPage = driver.findElement(By.linkText("Table Test Page"));
        fourthPage.click();
        System.out.println("Am accesat al patrulea link");
        WebElement pageParagraph2 = driver.findElement(By.className("explanation"));
        pageParagraph2.getText();
        System.out.println(pageParagraph2.getText());
        driver.navigate().back();
        System.out.println("M-am reintors pe pagina initiala");
    }

    public static void closeBrowser(){
        driver.quit();
    }

}