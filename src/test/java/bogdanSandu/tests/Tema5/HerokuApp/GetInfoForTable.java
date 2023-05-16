package bogdanSandu.tests.Tema5.HerokuApp;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetInfoForTable {

    public static void main(String[] args) {

        getInfoForTable();
    }

    public static void getInfoForTable(){
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
        WebElement fourthLinkTable = driver.findElement(By.id("tablehere"));
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
        driver.quit();
    }
}
