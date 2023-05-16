package elizCurtnazar.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CuraHealthcareLoginTests extends BaseTest {



    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword", "validCredentials"},
                {"John Do", "ThisIsNotAPassword", "invalidCredentials"}
        };
    }

        @Test
        public void loginWithValidCredentials() {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            WebElement menu = driver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
            menu.click();
            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    "Couldn't navigate to login page!");
            WebElement usernameInput = driver.findElement(By.name("username"));
            usernameInput.sendKeys("John Doe");
            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("ThisIsNotAPassword");
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    "Couldn't navigate to appointment page!");
    }

    @Test
    public void loginWithInvalidCredentials() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement menu = driver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Couldn't navigate to login page!");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("John Do");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement unsuccessfulLoginMessage = driver.findElement(By.className("text-danger"));
        Assert.assertEquals(unsuccessfulLoginMessage.getText(),
                "Login failed! Please ensure the username and password are valid.",//obligatoriu
                "Shouldn't navigate to appointment page!");//optional
    }

    @Test(dataProvider = "loginDataProvider", groups = "login")
    public void loginWithCredentials(String username, String password, String credentialsType) {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
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

}
