package elizCurtnazar.tests.tema9.gridtema5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

public class DemoQaManager {
    private String url;
    private static RemoteWebDriver remoteWebDriver = null;
    String fullName = "Curtnazar Eliz";
    String email = "eliz_rts_91@hotmail.com";
    String firstName = "Eliz";
    String lastName = "Curtnazar";
    //int age = 31;
    String age = "31";
    String salary = "1800";
    String department = "Marketing";


    public DemoQaManager(String url, RemoteWebDriver remoteWebDriver) {
        this.url = url;
        this.remoteWebDriver = remoteWebDriver;
        remoteWebDriver.get(url);
    }

    public static int selectTabElement() {
        List<WebElement> tabElement = remoteWebDriver.findElements(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
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

        WebElement textBox = remoteWebDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]/span"));
        textBox.click();
        WebElement fullNameTextBox = remoteWebDriver.findElement(By.id("userName"));
        fullNameTextBox.click();
        fullNameTextBox.clear();
        fullNameTextBox.sendKeys(fullName);
        WebElement emailTextBox = remoteWebDriver.findElement(By.id("userEmail"));
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
        WebElement submitButton = remoteWebDriver.findElement(By.id("submit"));
        submitButton.sendKeys(Keys.ENTER);

    }

    public void selectCheckBox() {
        WebElement checkBox = remoteWebDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]/span"));
        checkBox.click();
        WebElement clickBoxHome = remoteWebDriver.findElement(By.cssSelector("span.rct-title"));
        clickBoxHome.click();
        WebElement textAfisat = remoteWebDriver.findElement(By.id("result"));
        textAfisat.getText();
        System.out.println(textAfisat.getText());

    }

    public void selectRadioButton() {
        WebElement radioButton = remoteWebDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[3]"));
        radioButton.click();
        WebElement question = remoteWebDriver.findElement(By.cssSelector(".mb-3"));
        question.getText();
        System.out.println(question.getText());
        WebElement yesAnswer = remoteWebDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label"));
        yesAnswer.click();
        WebElement answer = remoteWebDriver.findElement(By.cssSelector(".mt-3"));
        answer.getText();
        System.out.println(answer.getText());
    }


    public void webTablesLink(String link) {

        String urlBase = "https://demoqa.com/";
        remoteWebDriver.get(urlBase + link);


        WebElement addButton = remoteWebDriver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstNameInput = remoteWebDriver.findElement(By.id("firstName"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = remoteWebDriver.findElement(By.id("lastName"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        WebElement emailInput = remoteWebDriver.findElement(By.id("userEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement ageInput = remoteWebDriver.findElement(By.id("age"));
        ageInput.click();
        ageInput.clear();
        ageInput.sendKeys(age);  // cum aduag in sendkeys un int?
        WebElement salaryInput = remoteWebDriver.findElement(By.id("salary"));
        salaryInput.click();
        salaryInput.clear();
        salaryInput.sendKeys(salary);
        WebElement departmentInput = remoteWebDriver.findElement(By.id("department"));
        departmentInput.click();
        departmentInput.clear();
        departmentInput.sendKeys(department);
        WebElement submitClick = remoteWebDriver.findElement(By.id("submit"));
        submitClick.click();

    }


    public void buttonsLink(String link) {
        String urlBase = "https://demoqa.com/";
        remoteWebDriver.get(urlBase + link);

        WebElement doubleClickMe = remoteWebDriver.findElement(By.id("doubleClickBtn"));
        doubleClickMe.click();

    }

    public WebElement linkElementLink(String link) {
        String urlBase = "https://demoqa.com/";
        remoteWebDriver.get(urlBase + link);

        List<WebElement> linkList = remoteWebDriver.findElements(By.id("linkWrapper"));
        List<String> list = new ArrayList<>();
        for (WebElement elem : linkList) {
            list.add(elem.getText());
        }
        System.out.println(list);
        WebElement homeLink = remoteWebDriver.findElement(By.id("simpleLink"));
        homeLink.click();
        return homeLink;
    }

    public static void closeBrowser(){
        remoteWebDriver.quit();
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
