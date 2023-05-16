package elizCurtnazar.tests.tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class DemoQaManager {
    private String url;
    private static ChromeDriver driver = null;
    String fullName = "Curtnazar Eliz";
    String email = "eliz_rts_91@hotmail.com";
    String firstName = "Eliz";
    String lastName = "Curtnazar";
    //int age = 31;
    String age = "31";
    String salary = "1800";
    String department = "Marketing";


    public DemoQaManager(String url, ChromeDriver driver) {
        this.url = url;
        this.driver = driver;
        driver.get(url);
    }

    public static int selectTabElement() {
        List<WebElement> tabElement = driver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
        List<String> nameTab = new ArrayList<>();
        for (WebElement elem : tabElement) {
            nameTab.add(elem.getText());
        }
        System.out.println(nameTab);
        WebElement textBox = tabElement.get(0);
        textBox.click();
        return tabElement.size();

    }

    public void selectTextBox() {

        WebElement textBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
        textBox.click();
        WebElement fullNameTextBox = driver.findElement(By.id("userName"));
        fullNameTextBox.click();
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys(fullName);
        WebElement emailTextBox = driver.findElement(By.id("userEmail"));
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.sendKeys(Keys.ENTER);

    }

    public void selectCheckBox() {
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]/span"));
        checkBox.click();
        WebElement clickBoxHome = driver.findElement(By.cssSelector("span.rct-title"));
        clickBoxHome.click();
        WebElement textAfisat = driver.findElement(By.id("result"));
        textAfisat.getText();
        System.out.println(textAfisat.getText());

    }

    public void selectRadioButton() {
        WebElement radioButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]"));
        radioButton.click();
        WebElement question = driver.findElement(By.cssSelector(".mb-3"));
        question.getText();
        System.out.println(question.getText());
        WebElement yesAnswer = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label"));
        yesAnswer.click();
        WebElement answer = driver.findElement(By.cssSelector(".mt-3"));
        answer.getText();
        System.out.println(answer.getText());
    }


    public void webTablesLink(String link) {

        String urlBase = "https://demoqa.com/";
        driver.get(urlBase + link);


        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement ageInput = driver.findElement(By.id("age"));
        ageInput.click();
        ageInput.clear();
        ageInput.sendKeys(age);  // cum aduag in sendkeys un int?
        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.click();
        salaryInput.clear();
        salaryInput.sendKeys(salary);
        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.click();
        departmentInput.clear();
        departmentInput.sendKeys(department);
        WebElement submitClick = driver.findElement(By.id("submit"));
        submitClick.click();

    }


    public void buttonsLink(String link) {
        String urlBase = "https://demoqa.com/";
        driver.get(urlBase + link);

        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();

    }

    public WebElement linkElementLink(String link) {
        String urlBase = "https://demoqa.com/";
        driver.get(urlBase + link);

        List<WebElement> linkList = driver.findElements(By.id("linkWrapper"));
        List<String> list = new ArrayList<>();
        for (WebElement elem : linkList) {
            list.add(elem.getText());
        }
        System.out.println(list);
        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        homeLink.click();
        return homeLink;
    }

    public static void closeBrowser(){
        driver.quit();
    }
}


// URMEAZA NISTE VARIANTE CARE AM INCERCAT, SI NU LE AM STERS CA SA MI RAMANA IN ISTORIC.
//       WebElement webTable = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[4]"));
//       webTable.click();
//       Actions actions = new Actions(driver);
//        actions.moveToElement(webTables).perform();
//        actions.click(webTables).perform();


//        List<String> nameTab =  new ArrayList<>();
//        for(WebElement elem:tabElement){
//            nameTab.add(elem.getText());
//        }
//
//        return nameTab;


// public static int selectTabElement() {
//        List<WebElement> tabElement = driver.findElements(By.cssSelector("ul.menu-list"));
//        WebElement textBox = tabElement.get(tabElement.size() - 6);
//        return tabElement.size() - 6;
