package cosminneagu.tests.tema5.Heroku;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableTestPage {
    static  ChromeDriver driver = null;
    public static void main(String[] args) {
        goToTheTableTestPage();
        firstParagraph();
        getInfoForTable();
        closeBrowser();
    }

    public static void goToTheTableTestPage() {

        driver = BrowserManager.createChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        System.out.println("Go to the link called Table Test Page");

        WebElement link4TableTestPage = driver.findElement(By.id("tablestest"));

        link4TableTestPage.click();

    }

    public static void firstParagraph(){

        WebElement firstParagraph = driver.findElement(By.className("explanation"));

        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());

    }

    public static void getInfoForTable(){

        WebElement titleSTable = driver.findElement(By.xpath("//*[contains(text(),'This table has information')]"));

        System.out.println("The table's title is called: " + titleSTable.getText());

        System.out.println("The table has the following body: ");

        WebElement table = driver.findElement(By.id("tablehere"));
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#tablehere table tr"));
        for (int i = 0;i<tableRows.size();i++){
            WebElement currentRow = tableRows.get(i);
            if (i == 0){
                List<WebElement> firstRowColumns = currentRow.findElements(By.cssSelector("th"));
                System.out.println("First Header: " + firstRowColumns.get(0).getText());
                System.out.println("Second Header: " + firstRowColumns.get(1).getText());
            } else {
                List<WebElement> currentColumns = currentRow.findElements(By.cssSelector("td"));
                System.out.println("Text from row " + (i + 1) + ", column 1: " + currentColumns.get(0).getText());
                System.out.println("Text from row " + (i + 1) + ", column 2: " + currentColumns.get(1).getText());
            }
        }
    }

    public static void closeBrowser(){

        driver.quit();
        System.out.println("The browser closed!");

    }

}
