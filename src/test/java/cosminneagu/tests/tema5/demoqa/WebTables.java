package cosminneagu.tests.tema5.demoqa;

import cosminneagu.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {
    public static void main(String[] args) {
        goToTheWebTables("Jon","Mike","test@test.com","50","60000","Marketing");

    }

    public static void goToTheWebTables(String firstName, String lastName, String email, String age, String salary, String department){

        ChromeDriver driver = BrowserManager.createChromeDriver();

        driver.get("https://demoqa.com/webtables");

        WebElement webTablesSection = driver.findElement(By.cssSelector("#item-3"));

        webTablesSection.click();

        WebElement addButton = driver.findElement(By.cssSelector("#addNewRecordButton"));

        addButton.click();

        WebElement firstNameField = driver.findElement(By.cssSelector("input[placeholder='First Name']"));

        firstNameField.click();

        firstNameField.sendKeys(firstName);

        WebElement lastNameField= driver.findElement(By.cssSelector("input[placeholder='Last Name']"));

        lastNameField.click();

        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));

        emailField.click();

        emailField.sendKeys(email);

        WebElement ageField = driver.findElement(By.cssSelector("input[placeholder='Age']"));

        ageField.click();

        ageField.sendKeys(age);

        WebElement salaryField = driver.findElement(By.cssSelector("input[placeholder='Salary']"));

        salaryField.click();

        salaryField.sendKeys(salary);

        WebElement departmentField = driver.findElement(By.cssSelector("input[id='department']"));

        departmentField.click();

        departmentField.sendKeys(department);

        WebElement submitButton = driver.findElement(By.cssSelector("button[id='submit']"));

        submitButton.click();

        WebElement deleteIcon = driver.findElement(By.cssSelector(" span[id='delete-record-4']"));

        deleteIcon.click();

        WebElement editIcon = driver.findElement(By.cssSelector("span[id='edit-record-2']"));

        editIcon.click();

        WebElement inputFirstNameIcon = driver.findElement(By.cssSelector("input[value='Alden']"));

        inputFirstNameIcon.click();

        inputFirstNameIcon.clear();

        inputFirstNameIcon.sendKeys(firstName);

        WebElement inputLastNameField = driver.findElement(By.cssSelector("input[value='Cantrell']"));

        inputLastNameField.click();

        inputLastNameField.clear();

        inputLastNameField.sendKeys(lastName);

        WebElement inputEmailField = driver.findElement(By.cssSelector(" input[value='alden@example.com']"));

        inputEmailField.click();

        inputEmailField.clear();

        inputEmailField.sendKeys(email);

        WebElement inputAgeField = driver.findElement(By.cssSelector(" input[value='45']"));

        inputAgeField.click();

        inputAgeField.clear();

        inputAgeField.sendKeys(age);

        WebElement inputSalaryField = driver.findElement(By.cssSelector("input[value='12000']"));

        inputSalaryField.click();

        inputSalaryField.clear();

        inputSalaryField.sendKeys(salary);

        WebElement inputDepartmentField = driver.findElement(By.cssSelector("input[value='Compliance']"));

        inputDepartmentField.click();

        WebElement buttonSubmit = driver.findElement(By.cssSelector("button[type='submit']"));

        buttonSubmit.click();

        WebElement typeToSearchButton = driver.findElement(By.cssSelector("input[placeholder='Type to search']"));

        typeToSearchButton.click();

        typeToSearchButton.sendKeys("Cierra");

        typeToSearchButton.sendKeys(Keys.ENTER);

        driver.quit();

    }
}
