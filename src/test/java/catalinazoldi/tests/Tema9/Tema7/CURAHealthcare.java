package catalinazoldi.tests.Tema9.Tema7;

import catalinazoldi.tests.Tema9.Tema7.BaseTest;
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

public class CURAHealthcare extends BaseTest {


    @DataProvider(name = "data-set")
    public Object[][] loginDataProvider(){
        return new Object[][]{
                {"valid", "John Doe", "ThisIsNotAPassword",},
                {"invalid", "John Do", "ThisIsNotAPassword",}
        };
    }
    @Test(dataProvider = "data-set")
    public void login(String type, String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        System.out.println("Am dat click pe menu!");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a"));
        loginButton.click();
        System.out.println("Am facut click pe butonul Login din Menu!");
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        WebElement buttonLogin = driver.findElement(By.id("btn-login"));
        buttonLogin.click();
        if (type.equals("valid")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#appointment > div > div > div > h2")));
            driver.getCurrentUrl();
            assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", driver.getCurrentUrl());
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#login > div > div > div.col-sm-12.text-center > p.lead.text-danger")));
            assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login", driver.getCurrentUrl());
        }
    }

        @DataProvider(name = "appointmentData")
        public Object[][] appointmentInfo () {
            return new Object[][]{
                    {"08.02.2023", "Test", true},
                    {"08.02", "Test", false},
            };
        }

    public void completeDetailsForAppointment() {
        WebElement firstField = driver.findElement(By.id("txt-username"));
        firstField.sendKeys("John Doe");
        WebElement secondField = driver.findElement(By.id("txt-password"));
        secondField.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }
    @Test(dataProvider = "appointmentData")
    public void makeAppointment(String data, String comment, boolean pass) {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement appointment = driver.findElement(By.id("btn-make-appointment"));
        appointment.click();
        completeDetailsForAppointment();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByVisibleText("Tokyo CURA Healthcare Center");
        System.out.println("Am selectat facility");
        WebElement applyForHospitalReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        applyForHospitalReadmission.click();
        System.out.println("Am selectat: Apply for hospital readmission");
        WebElement medicare = driver.findElement(By.id("radio_program_medicare"));
        medicare.click();
        System.out.println("Am selectat program pentru CURAHealthcare!");
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys(data);
        System.out.println("Am selectat data!");
        WebElement commentField = driver.findElement(By.id("txt_comment"));
        commentField.sendKeys(comment);
        System.out.println("Am completata comment section!");
        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();
        System.out.println("Click pe booking appointment");
        if (pass) {
            assertTrue(driver.findElement(By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2")).isDisplayed());
        } else {
            assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", driver.getCurrentUrl());
        }
    }
    @Test
    public void redirectToLogin() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppoinntmentButton = driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppoinntmentButton.click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login", driver.getCurrentUrl());
    }
    @Test
    public void homeButton() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement buttonMenu = driver.findElement(By.cssSelector("#menu-toggle"));
        buttonMenu.click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/", driver.getCurrentUrl());
    }
}



