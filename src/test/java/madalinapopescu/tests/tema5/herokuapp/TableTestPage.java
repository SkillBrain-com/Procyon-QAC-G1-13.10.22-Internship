package madalinapopescu.tests.tema5.herokuapp;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TableTestPage {
    public static void main(String[] args) {
        goToTableTestPage();
    }
    public static void goToTableTestPage() {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fourthlink = driver.findElement(By.id("tablestest"));
        System.out.println("AL patrulea link are textul: "+ fourthlink.getText());
        fourthlink.click();
            WebElement tableLinkPageTitle = driver.findElement(By.cssSelector("div h1"));
            System.out.println("Titlul tabelului este " + tableLinkPageTitle.getText());
            WebElement tablePageExplanation = driver.findElement(By.className("explanation"));
            System.out.println("Avem si explicatii >> " + tablePageExplanation.getText());
            WebElement tableLinkTable = driver.findElement(By.id("mytable"));
            System.out.println("Avem si un tabel >> " + tableLinkTable.getText());
        driver.quit();

    }
}
