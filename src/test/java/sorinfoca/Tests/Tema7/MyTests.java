package sorinfoca.Tests.Tema7;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyTests extends TestConfig {

    @DataProvider(name = "loginDataProvider")
    public static Object[][] loginData() {
        return new Object[][] {
                {"John Doe", "ThisIsNotAPassword", true},
                {"invalid_username", "invalid_password", false},
        };
    }

    @DataProvider(name = "appointmentDataProvider")
    public static Object[][] appointmentData() {
        return new Object[][] {
                {"10/10/23", "Comentariu pozitiv", true},
                {"", "Comentariu negativ", false},
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(String username, String password, boolean shouldPass) {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("#txt-username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        if(shouldPass) {
            assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment",driver.getCurrentUrl());
        }
        else {
            assertTrue(driver.findElement(By.cssSelector("#login > div > div > div.col-sm-12.text-center > p.lead.text-danger")).isDisplayed());
        }
    }

    @Test(dataProvider = "appointmentDataProvider")
    public void testAppointment(String data, String comentariu, boolean shouldPass){
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.cssSelector("#chk_hospotal_readmission")).click();
        driver.findElement(By.cssSelector("#radio_program_medicaid")).click();
        driver.findElement(By.name("visit_date")).sendKeys(data);
        driver.findElement(By.cssSelector("#txt_comment")).sendKeys(comentariu);
        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
        if(shouldPass) {
            assertTrue(driver.findElement(By.cssSelector("#summary > div > div > div.col-xs-12.text-center > h2")).isDisplayed());
        }
        else {
            assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", driver.getCurrentUrl());
        }
    }

    @Test
    public void test1() {
        testRedirectToLogin();
        testHomeButton();
    }

    public void testRedirectToLogin() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#btn-make-appointment")).click();
        assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login",driver.getCurrentUrl());
    }

    public void testHomeButton() {
        driver.get(getBaseUrl());
        driver.findElement(By.cssSelector("#menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a")).click();
        assertEquals(getBaseUrl() , driver.getCurrentUrl());
    }
}
