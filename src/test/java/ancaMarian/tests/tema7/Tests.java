package ancaMarian.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests extends Configurations {

    @DataProvider(name = "loginDetails")
    public Object[][] loginDetails(){
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword", true},
                {"WrongUsername", "WrongPassword", false},
                {"", "", false}
        };
    }

    @DataProvider(name = "appointmentDetails")
    public Object[][] appointmentDetails(){
        return new Object[][]{
                {"1/03/2023", "comment", true}, //this test should pass
                {"1/03/2023", " ", true}, //this test should pass
                {"1/03/2021", "comment", false}, // this test SHOULD FAIL, because it's an appointment in the past
                {"", "comment", false}, // this test should pass, it should NOT take me to Appointment Confirmation Page
                {"", "", false} // this test should pass, it should NOT take me to Appointment Confirmation Page
        };
    }

    @Test(dataProvider = "loginDetails")
    public void loginTest(String username, String password, boolean testShouldPass) {
        driver.get(url);
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a"));
        loginButton.click();
        WebElement inputUsername = driver.findElement(By.id("txt-username"));
        inputUsername.click();
        inputUsername.sendKeys(username);
        WebElement inputPassword = driver.findElement(By.id("txt-password"));
        inputPassword.click();
        inputPassword.sendKeys(password);
        WebElement loginSubmitButton = driver.findElement(By.id("btn-login"));
        loginSubmitButton.click();
        if (testShouldPass){
            Assert.assertEquals (driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        } else {
            Assert.assertEquals (driver.findElement(By.xpath("//*[@id='login']/div/div/div[1]/p[2]")).getText(), "Login failed! Please ensure the username and password are valid.");
        }
    }

    @Test
    public void clickOnMakeAppointmentWithoutLoginBeforeRedirectsToLoginPage() {
        driver.get(url);
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    @Test(dataProvider = "appointmentDetails")
    public void makeAnAppointment(String data, String comentariu, boolean testShouldPass) {
        driver.get(url);
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        WebElement inputUsername = driver.findElement(By.id("txt-username"));
        inputUsername.click();
        inputUsername.sendKeys("John Doe");
        WebElement inputPassword = driver.findElement(By.id("txt-password"));
        inputPassword.click();
        inputPassword.sendKeys("ThisIsNotAPassword");
        WebElement loginSubmitButton = driver.findElement(By.id("btn-login"));
        loginSubmitButton.click();
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys(data);
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys(comentariu);
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();
        if (testShouldPass) {
            Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        } else {
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");}
    }

   @Test
   public void returnToHomepage() {
        returnToHomePageFromHomepageMenu();
        closeDriver();
        setupDriver();
        returnToHomepageFromLoginPage();
        closeDriver();
        setupDriver();
        returnToHomepageFromAppointmentFormPage();
        closeDriver();
        setupDriver();
        returnToHomepageFromAppointmentConfirmationPage();
   }

    public void returnToHomePageFromHomepageMenu() {
        driver.get(url);
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement homeFromMenuInHomePage = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[2]/a"));
        homeFromMenuInHomePage.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }

    public void returnToHomepageFromLoginPage() {
        driver.get(url);
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[3]/a"));
        loginButton.click();
        WebElement menuButtonFromLoginPage = driver.findElement(By.id("menu-toggle"));
        menuButtonFromLoginPage.click();
        WebElement homeFromMenuInLoginPage = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[2]/a"));
        homeFromMenuInLoginPage.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }

    public void returnToHomepageFromAppointmentFormPage() {
        driver.get(url);
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        WebElement inputUsername = driver.findElement(By.id("txt-username"));
        inputUsername.click();
        inputUsername.sendKeys("John Doe");
        WebElement inputPassword = driver.findElement(By.id("txt-password"));
        inputPassword.click();
        inputPassword.sendKeys("ThisIsNotAPassword");
        WebElement loginSubmitButton = driver.findElement(By.id("btn-login"));
        loginSubmitButton.click();
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement homeFromMenuInAppointmentFormPage = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[2]/a"));
        homeFromMenuInAppointmentFormPage.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }

    public void returnToHomepageFromAppointmentConfirmationPage() {
        driver.get(url);
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        WebElement inputUsername = driver.findElement(By.id("txt-username"));
        inputUsername.click();
        inputUsername.sendKeys("John Doe");
        WebElement inputPassword = driver.findElement(By.id("txt-password"));
        inputPassword.click();
        inputPassword.sendKeys("ThisIsNotAPassword");
        WebElement loginSubmitButton = driver.findElement(By.id("btn-login"));
        loginSubmitButton.click();
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys("1/03/2023");
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("comment");
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement homeButtonFromMenuInAppointmentConfirmationPage = driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[2]/a"));
        homeButtonFromMenuInAppointmentConfirmationPage.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }
    }
