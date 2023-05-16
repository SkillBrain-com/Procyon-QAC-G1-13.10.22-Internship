package madalinapopescu.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CuraHealthcareMakeAppointmentTest extends BaseTest{

    @DataProvider(name = "appointmentData")
    public Object [][] appointmentInfo(){
        return new Object[][]{
                {"03.02.2023","Programarea mea","validCredentials"},
                {"01.2023","Programarea mea","invalidCredentials"},
        };
    }

    public void loghinToMakeAppointment(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }

    @Test(dataProvider = "appointmentData")
    public void makeAppointment(String data, String comment, String credentialsType){
        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();
        loghinToMakeAppointment();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByVisibleText("Hongkong CURA Healthcare Center");
        WebElement applyForHospital = driver.findElement(By.id("chk_hospotal_readmission"));
        applyForHospital.click();
        WebElement medicaid = driver.findElement(By.id("radio_program_medicaid"));
        medicaid.click();
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys(data);
        WebElement commentField = driver.findElement(By.id("txt_comment"));
        commentField.sendKeys(comment);
        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();
        if (credentialsType.equals("validCredentials")){
            assertTrue(driver.findElement(By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2")).isDisplayed());
        }else {
            assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary",driver.getCurrentUrl());
        }
    }

    @Test
    public void homeButton() {
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement homeButton = driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a"));
        homeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Couldn't navigate to home page!");
    }
}
