package elizCurtnazar.tests.tema9.gridtema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestPagesHerokuappManager {
    //atribute
    private String url; //pagina la care lucram
    private static RemoteWebDriver remoteWebDriver = null; //salvam instanta de chrome pe care o vom folosi in toate metodele de clasa

    //constructori

    public TestPagesHerokuappManager(String url, RemoteWebDriver remoteWebDriver){
        this.url = url;
        this.remoteWebDriver = remoteWebDriver;
        remoteWebDriver.get(url);

        //  driver.close(); //inchide doar tabul in care ne aflam
        // driver.quit(); //inchide toata sesiune de chrome
    }

    //referentiem un obiect cu WebElement si instantiem cu metododa driver.findElement

    public static void goToTheFirstPage(){

        WebElement firstPage = remoteWebDriver.findElement(By.linkText("Basic Web Page Example"));
        firstPage.click();
        System.out.println("Am acessat primul link.");
        WebElement Paragraph = remoteWebDriver.findElement(By.className("explanation")); //cssselector(div.explanation p)
        Paragraph.getText();
        System.out.println(Paragraph.getText());
        remoteWebDriver.navigate().back();
        System.out.println("M-am intors la pagina initiala");

    }

    public static void goToTheSecondPage() {
        WebElement secondPage = remoteWebDriver.findElement(By.linkText("Element Attributes Examples"));
        secondPage.click();
        System.out.println("Am accesat al doilea link");
        WebElement button = remoteWebDriver.findElement(By.cssSelector("div.centered button"));
        button.click();
        System.out.println("Am dat click pe Add Another Attribute");
        remoteWebDriver.navigate().back();
        System.out.println("M-am reintors pe pagina initiala");
    }

    public static void goToTheThirdPage() {
        WebElement thirdPage = remoteWebDriver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        thirdPage.click();
        System.out.println("Am accesat al treila link ");
        WebElement pageParagraph = remoteWebDriver.findElement(By.className("explanation"));
        pageParagraph.getText();
        System.out.println(pageParagraph.getText());
        remoteWebDriver.navigate().back();
        System.out.println("M-am reintors la pagina initiala");
    }

    public static void goToTheFourthPage() {
        WebElement fourthPage = remoteWebDriver.findElement(By.linkText("Table Test Page"));
        fourthPage.click();
        System.out.println("Am accesat al patrulea link");
        WebElement pageParagraph2 = remoteWebDriver.findElement(By.className("explanation"));
        pageParagraph2.getText();
        System.out.println(pageParagraph2.getText());
        remoteWebDriver.navigate().back();
        System.out.println("M-am reintors pe pagina initiala");
    }

    public static void closeBrowser(){
        remoteWebDriver.quit();
    }

}