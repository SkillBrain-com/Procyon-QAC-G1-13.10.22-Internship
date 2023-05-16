package bogdanSandu.tests.Tema5.DemoQa;

import bogdanSandu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateTextTables {

    public static void main(String[] args) {

        updateTextTables();
    }

    public static void updateTextTables() {
        ChromeDriver driver = BrowserManager.createDriverAndGetPage();
        driver.get("https://demoqa.com/webtables");
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Bob");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Bob");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("contmail@gmail.com");
        WebElement age = driver.findElement(By.id("age"));
        age.click();
        age.clear();
        age.sendKeys("28");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.click();
        salary.clear();
        salary.sendKeys("3500");
        WebElement department = driver.findElement(By.id("department"));
        department.click();
        department.clear();
        department.sendKeys("QA Engineer");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        driver.quit();
    }
}
