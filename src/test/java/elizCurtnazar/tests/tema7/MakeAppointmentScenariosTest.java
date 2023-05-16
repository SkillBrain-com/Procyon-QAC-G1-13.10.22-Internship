package elizCurtnazar.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MakeAppointmentScenariosTest extends BaseTest {

    @Test
    public void clickMakeAppointmentButton() {
        System.out.println("Aici incepe scenariul pozitiv");
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("Navigate to https://katalon-demo-cura.herokuapp.com/#appointment");
        Select facilityMultipleSelect = new Select(driver.findElement(By.xpath("/html/body/section/div/div/form/div[1]/div/select")));
        facilityMultipleSelect.selectByValue("Seoul CURA Healthcare Center");
        System.out.println("Seoul CURA Healthcare Center is selected!");
        WebElement checkboxReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        checkboxReadmission.click();
        List<WebElement> radioItemHealtcareProgram = driver.findElements(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div"));
        radioItemHealtcareProgram.get(0);
        WebElement inputVisitDate = driver.findElement(By.id("txt_visit_date"));
        inputVisitDate.sendKeys("11/12/2023");
        System.out.println("Am facut programarea pe data de 11/12/2023");
        WebElement inputComment = driver.findElement(By.cssSelector("#txt_comment"));
        inputComment.click();
        inputComment.clear();
        inputComment.sendKeys("Asta este parte din tema 7");
        System.out.println(inputComment.getText());
        WebElement bookAppointmentButton = driver.findElement(By.cssSelector("#btn-book-appointment"));
        bookAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        System.out.println("Aici se termina scenariul pozitiv");
    }

    @Test
    public void negativScenarioMakeAppointment (){

        System.out.println("Aici incepe scenariul negativ");
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("Navigate to https://katalon-demo-cura.herokuapp.com/#appointment");
        Select facilityMultipleSelect = new Select(driver.findElement(By.xpath("/html/body/section/div/div/form/div[1]/div/select")));
        facilityMultipleSelect.selectByValue("Seoul CURA Healthcare Center");
        System.out.println("Seoul CURA Healthcare Center is selected!");
        WebElement checkboxReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        checkboxReadmission.click();
        List<WebElement> radioItemHealtcareProgram = driver.findElements(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div"));
        radioItemHealtcareProgram.get(0);
        System.out.println("Is not input data in the field of Visit Date, which is required!");
        //Visit Date is Required
//        WebElement inputVisitDate = driver.findElement(By.id("txt_visit_date"));
//        inputVisitDate.sendKeys("11/12/2023"); ERA MAI BINE INAINTE .... STERGE DATA PROVIDERUL DE AICI
//        System.out.println("Am facut programarea pe data de 11/12/2023");
        WebElement inputComment = driver.findElement(By.cssSelector("#txt_comment"));
        inputComment.click();
        inputComment.clear();
        inputComment.sendKeys("Asta este parte din tema 7");
        System.out.println(inputComment.getText());
        WebElement bookAppointmentButton = driver.findElement(By.cssSelector("#btn-book-appointment"));
        bookAppointmentButton.click();
        Assert.assertNotEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/appointment.php#summary",
                    "Make Appointment page is failed!");
        System.out.println("Aici se termina scenariul negativ");
    }
}

// StaleElementReferenceException: cand atentia este pe un element dar, valoarea acesteia se schimba.
