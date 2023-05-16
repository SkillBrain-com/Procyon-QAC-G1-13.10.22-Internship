package madalinapopescu.tests.tema5.demoqa;

import madalinapopescu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class  WebTables {
    public static void main(String[] args) {
        goToWebTables();
    }
    public static void goToWebTables(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement webTables = driver.findElement(By.cssSelector("#item-3"));
        webTables.click();
        WebElement AddButton = driver.findElement(By.cssSelector("#addNewRecordButton"));
        AddButton.click();
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstName.click();
        firstName.sendKeys("Ana");
        WebElement lastName= driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastName.click();
        lastName.sendKeys("Maria");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        email.click();
        email.sendKeys("ana@mail.com");
        WebElement age = driver.findElement(By.cssSelector("input[placeholder='Age']"));
        age.click();
        age.sendKeys("22");
        WebElement salary = driver.findElement(By.cssSelector("input[placeholder='Salary']"));
        salary.click();
        salary.sendKeys("3000");
        WebElement department= driver.findElement(By.cssSelector("input[id='department']"));
        department.click();
        department.sendKeys("administrator");
        WebElement SubmitButton = driver.findElement(By.cssSelector("button[id='submit']"));
        SubmitButton.click();
        WebElement deleteIcon = driver.findElement(By.cssSelector(" span[id='delete-record-4']"));
        deleteIcon.click();
        driver.quit();
    }
}
