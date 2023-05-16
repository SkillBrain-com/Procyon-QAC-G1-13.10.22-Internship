package cosminneagu.tests.tema5.Heroku;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableTestPage {
    public static void main(String[] args) {
        goToTheDynamicTableTestPage();

        getTableData("George", "1567");

    }
    public static void goToTheDynamicTableTestPage() {

        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement link4TDynamicTable = driver.findElement(By.id("dynamictablestest"));
        link4TDynamicTable.click();
        WebElement firstParagraph = driver.findElement(By.cssSelector(".explanation"));
        System.out.println("The first paragraph has the following content: " + firstParagraph.getText());
        WebElement tableSTitle = driver.findElement(By.xpath("//caption[text()='Dynamic Table']"));
        System.out.println("The table's title is called: " + tableSTitle.getText());
        WebElement table = driver.findElement(By.cssSelector("#dynamictable"));
        System.out.println("The table has the following body: " + table.getText());
        WebElement buttonTableData = driver.findElement(By.xpath("//summary[text()='Table Data']"));
        buttonTableData.click();
        driver.quit();
    }

    public static void getTableData(String captionInput, String idInput) {
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        WebElement buttonTableData = driver.findElement(By.xpath("//summary[text()='Table Data']"));
        buttonTableData.click();
        WebElement newCaptionInput = driver.findElement(By.id("caption"));
        WebElement newIdInput = driver.findElement(By.id("tableid"));
        newCaptionInput.click();
        newCaptionInput.clear();
        newCaptionInput.sendKeys(captionInput);
        newIdInput.click();
        newIdInput.clear();
        newIdInput.sendKeys(idInput);
        WebElement refreshTable = driver.findElement(By.id("refreshtable"));
        refreshTable.click();
        driver.quit();
    }
}
