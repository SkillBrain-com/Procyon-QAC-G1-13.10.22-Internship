package ioanandroflorea.tests.Tema5;

import ioanandroflorea.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQA {
    public static void main(String[] args) {
        textBox();
        checkBox();
        radioButton();
        webTables();
        button();
    }

    public static void textBox(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement textBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
        textBox.click();
        WebElement fullNameTextBox = driver.findElement(By.id("userName"));
        fullNameTextBox.click();
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys("John Doe");
        WebElement emailTextBox = driver.findElement(By.id("userEmail"));
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys("johndoe@yahoo.com");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.sendKeys(Keys.ENTER);
        driver.quit();
    }

    public static void checkBox(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
        WebElement clickBoxHome = driver.findElement(By.cssSelector("span.rct-title"));
        clickBoxHome.click();
        WebElement textAfisat = driver.findElement(By.id("result"));
        textAfisat.getText();
        System.out.println(textAfisat.getText());
        WebElement clickPlus = driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all"));
        clickPlus.click();
        WebElement clickMinus = driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-collapse-all"));
        clickMinus.click();
        driver.quit();
    }
    public static void radioButton(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();
        WebElement radioButtonAnswer = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonAnswer.click();
        driver.quit();
    }

    public static void webTables(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement webTables = driver.findElement(By.id("item-3"));
        webTables.click();
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Doe");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("johndoe@yahoo.com");
        WebElement age = driver.findElement(By.id("age"));
        age.click();
        age.clear();
        age.sendKeys("22");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.click();
        salary.clear();
        salary.sendKeys("2200");
        WebElement department = driver.findElement(By.id("department"));
        department.click();
        department.clear();
        department.sendKeys("Management");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        driver.quit();
    }

    public static void button(){
        ChromeDriver driver = BrowserManager.createChromeDriver();
        driver.get("https://demoqa.com/elements");
        WebElement buttons = driver.findElement(By.xpath("//*[@id=\"item-4\"]"));
        buttons.click();
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();
        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        rightClickMe.click();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        rightClickMessage.getText();
        driver.quit();
    }
}
