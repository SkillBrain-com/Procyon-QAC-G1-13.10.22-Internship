package catalinazoldi.tests.Tema9.Tema5.DemoqaElements;

import catalinazoldi.teorie.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebTables {
    public static void main(String[] args) {
        goToWebTablesPage();

    }
    public static void goToWebTablesPage() {
        RemoteWebDriver driver;
        driver = BrowserManager.createRemoteWebDriver();
        driver.get("https://demoqa.com/webtables");
        WebElement typeToSearchButton = driver.findElement(By.cssSelector("input[placeholder='Type to search']"));
        typeToSearchButton.click();
        typeToSearchButton.sendKeys("Alden");
        typeToSearchButton.sendKeys(Keys.ENTER);
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
         firstName.click();
        firstName.sendKeys("Harry");
        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastName.click();
        lastName.sendKeys("Potter");
        WebElement fullAge = driver.findElement(By.cssSelector("input[placeholder='Age']"));
        fullAge.click();
        fullAge.sendKeys("25");
        WebElement eMail = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        eMail.click();
        eMail.sendKeys("potter@mail.com");
        WebElement salary = driver.findElement(By.cssSelector("input[placeholder='Salary']"));
        salary.click();
        salary.sendKeys("40000");
        WebElement departament = driver.findElement(By.cssSelector("input[id='department']"));
        departament.click();
        departament.sendKeys("ofMysteries");
        WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));
        submitButton.click();
        driver.quit();
        System.out.println("Am rulat testul!");
  }
}
