package bogdanSandu.tests.Tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CURAHealthcare extends TestBase {

    @DataProvider(name = "data-set")
    public Object[][] loginDataProvider(){
        return new Object[][]{
                {"valid", "John Doe", "ThisIsNotAPassword",},
                {"invalid", "John Do", "ThisIsNotAPassword",}
        };
    }

    @Test(dataProvider = "data-set")
    public void login(String type, String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.id("menu-toggle")).click();
        System.out.println("Click on menu");
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();
        System.out.println("Click on login menu");
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        if(type.equals("valid")){
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#appointment > div > div > div > h2")));
            driver.getCurrentUrl();
        }else
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#login > div > div > div.col-sm-12.text-center > p.lead.text-danger")));
    }

   @DataProvider (name = "appointmentData")
    public Object [][] appointmentInfo(){
            return new Object[][]{
            {"01.01.2023","Test",true},
            {"01.01","Test",false},
        };
    }

    public void completeDetailsForAppointment(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }

    @Test(dataProvider = "appointmentData")
    public void makeAppointment(String data, String comment, boolean pass){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();
        completeDetailsForAppointment();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByVisibleText("Tokyo CURA Healthcare Center");
        System.out.println("Select facility");
        WebElement applyForHospitalReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        applyForHospitalReadmission.click();
        System.out.println("Select: Apply for hospital readmission");
        WebElement medicare = driver.findElement(By.id("radio_program_medicare"));
        medicare.click();
        System.out.println("Select program for healtcare");
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys(data);
        System.out.println("Select date");
        WebElement commentField = driver.findElement(By.id("txt_comment"));
        commentField.sendKeys(comment);
        System.out.println("Complete on comment section");
        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();
        System.out.println("Clisk on booking appointment");
        if (pass){
            assertTrue(driver.findElement(By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2")).isDisplayed());
        }else {
            assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary",driver.getCurrentUrl());
        }
    }

    @Test
    public void redirectToLogin() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.cssSelector("#btn-make-appointment")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login",driver.getCurrentUrl());
    }

    @Test
    public void homeButton() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/", driver.getCurrentUrl());
    }
}
