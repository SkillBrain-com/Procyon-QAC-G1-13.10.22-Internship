package andreeaG.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CuraHealthCareLogin extends BaseTest {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword", "validCredentials"},
                {"John Do", "ThisIsNotAPassword", "invalidCredentials"}
        };
    }

    @Test(dataProvider = "loginDataProvider", groups = "login")
    public void loginWithCredentials(String username, String password, String credentialsType) {
        WebElement menu = driver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Couldn't navigate to login page!");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        if (credentialsType.equals("validCredentials")) {
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    "Couldn't navigate to appointment page!");
        } else {
            WebElement unsuccessfulLoginMessage = driver.findElement(By.className("text-danger"));
            Assert.assertEquals(unsuccessfulLoginMessage.getText(),
                    "Login failed! Please ensure the username and password are valid.",
                    "Shouldn't navigate to appointment page!");
        }
    }

    @Test(groups = "redirect")
    public void verifyRedirectToLoginWhenUserNotLoggedIn() {
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "User is not redirected to login page when not logged in!");
    }


    @DataProvider(name = "appointmentData")
    public Object[][] appointmentData() {
        return new Object[][]{
                {"03/02/2023", "Successful Appointment", true},
                {"05/10/1990", "Unsuccessful", false}
        };
    }

    @Test(dataProvider = "appointmentData")
    public void makeAppointmentPage(String data, String comment, boolean testSuccess) {
        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();
        WebElement userNameBox = driver.findElement(By.id("txt-username"));
        userNameBox.sendKeys("John Doe");
        WebElement passwordBox = driver.findElement(By.id("txt-password"));
        passwordBox.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();
        Select facilityDropdown = new Select(driver.
                findElement(By.id("combo_facility")));
        facilityDropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
        WebElement hospReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        hospReadmission.click();
        System.out.println("Hospital readmission selected");
        WebElement healthcareProgramNone = driver.findElement(By.id("radio_program_none"));
        healthcareProgramNone.click();
        WebElement dataPicker = driver.findElement(By.id("txt_visit_date"));
        dataPicker.sendKeys(data);
        WebElement commentBox = driver.findElement(By.id("txt_comment"));
        commentBox.sendKeys(comment);
        WebElement apptBookButton = driver.findElement(By.id("btn-book-appointment"));
        apptBookButton.click();
        if (testSuccess) {
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/appointment.php#summary",
                    "Appointment booked!");
        } else {
            Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", driver.getCurrentUrl());
        }
    }

    @Test(groups = "Home Button")
    public void homeButtonWhenLoggedInHistory() {
        driver.get("https://katalon-demo-cura.herokuapp.com/history.php#history");
        WebElement purpleRightButton = driver.findElement(By.id("menu-toggle"));
        purpleRightButton.click();
        WebElement homeButton = driver.findElement(By.xpath(
                "//a[normalize-space()='Home']"));
        homeButton.click();
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/",driver.getCurrentUrl());
    }

    @Test(groups = "Home Button")
    public void homeButtonWhenLoggedInProfile() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        WebElement purpleRightButton = driver.findElement(By.id("menu-toggle"));
        purpleRightButton.click();
        WebElement homeButton = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        homeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Redirected to Home page!");
    }

    @Test(groups = "Home Button")
    public void homeButtonFromMakeAppointmentPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement purpleRightButton = driver.findElement(By.id("menu-toggle"));
        purpleRightButton.click();
        WebElement homeButton = driver.findElement(By.cssSelector("nav[id='sidebar-wrapper'] li:nth-child(2) a:nth-child(1)"));
        homeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Redirected to Home page!");
    }

}