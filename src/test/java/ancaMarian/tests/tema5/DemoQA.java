package ancaMarian.tests.tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQA {
    private static String url;
    private static ChromeDriver driver = null;

    DemoQA(String url, ChromeDriver driver) {
        this.url = url;
        this.driver = driver;
        driver.get(url);
    }
    public static void checkTextBox() {
        WebElement textBox = driver.findElement(By.xpath("//*[@id='item-0']/span"));
        textBox.click();
    }

    public static void enterFullName() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.clear();
        fullName.sendKeys("Pop Maria");
    }

    public static void enterEmail() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("popmaria@gmail.com");
    }

    public static void enterCurrentAddress() {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.clear();
        currentAddress.sendKeys("casa mea dulce de acasa");
    }

    public static void enterPermanentAddress() {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        permanentAddress.click();
        permanentAddress.clear();
        permanentAddress.sendKeys("cea mai dulce casa");
    }

    public static void submitButton() {
        WebElement clickSubmitButton = driver.findElement(By.cssSelector("#submit"));
        clickSubmitButton.click();
    }

    public static void checkCheckBox() {
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
    }

    public static void homeFolder() {
        WebElement clickOnHome = driver.findElement(By.className("rct-title"));
        clickOnHome.click();
    }

    public static void expand() {
        WebElement clickOnPlus = driver.findElement(By.cssSelector("[title='Expand all']"));
        clickOnPlus.click();
    }

    public static void deselect() {
        WebElement deselectFolder = driver.findElement(By.cssSelector("#tree-node-notes+.rct-checkbox"));
        deselectFolder.click();
    }

    public static void collapse() {
        WebElement clickOnMinus = driver.findElement(By.cssSelector("[title='Collapse all']"));
        clickOnMinus.click();
    }

    public static void checkRadioButton() {
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();
    }

    public static void clickRadioButton() {
        WebElement radioButtonYes = driver.findElement(By.cssSelector("[for='yesRadio']"));
        radioButtonYes.click();
    }

    public static void checkWebTables() {
        WebElement webTables = driver.findElement(By.id("item-3"));
        webTables.click();
    }

    public static void addNewRecord() {
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
    }

    public static void addFirstName() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Ana");
    }

    public static void addLastName() {
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Maria");
    }

    public static void addEmail() {
        WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
        email.click();
        email.clear();
        email.sendKeys("anamaria@gmail.com");
    }

    public static void addAge() {
        WebElement age = driver.findElement(By.xpath("//*[@id='age']"));
        age.click();
        age.clear();
        age.sendKeys("22");
    }

    public static void addSalary() {
        WebElement salary = driver.findElement(By.xpath("//*[@id='salary']"));
        salary.click();
        salary.clear();
        salary.sendKeys("2200");
    }

    public static void addDepartment() {
        WebElement department = driver.findElement(By.xpath("//*[@id='department']"));
        department.click();
        department.clear();
        department.sendKeys("boss");
    }

    public static void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
        submitButton.click();
    }

    public static void useSearchBar() {
        WebElement searchBar = driver.findElement(By.id("searchBox"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("ana");
        searchBar.clear();
    }

    public static void edit() {
        WebElement editButton = driver.findElement(By.cssSelector("#edit-record-4 > svg"));
        editButton.click();
        WebElement departmentToEdit = driver.findElement(By.id("department"));
        departmentToEdit.click();
        departmentToEdit.clear();
        departmentToEdit.sendKeys("intern");
        WebElement submitButtonInEdit = driver.findElement(By.cssSelector("#submit"));
        submitButtonInEdit.click();
    }

    public static void delete() {
        WebElement deleteRecord = driver.findElement(By.id("delete-record-4"));
        deleteRecord.click();
    }

    public static void buttons() {
        WebElement buttons = driver.findElement(By.id("item-4"));
        buttons.click();
    }

    public static void doubleClick() {
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actionDoubleClick = new Actions(driver);
        actionDoubleClick.doubleClick(doubleClickButton).perform();
        System.out.println("S-a facut double click-ul");
    }

    public static void rightClick(){
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(rightClickButton).perform();
        System.out.println("s-a facut right click-ul");
    }

    public static void clickButton(){
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickButton.click();
        System.out.println("s-a facut click-ul");
    }

    public static void links(){
        WebElement link = driver.findElement(By.id("item-5"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        link.click();
    }

    public static void openFirstLink(){
        WebElement firstLink = driver.findElement(By.id("simpleLink"));
        String originalWindow = driver.getWindowHandle();
        firstLink.click();
        driver.switchTo().window(originalWindow);
    }
}
