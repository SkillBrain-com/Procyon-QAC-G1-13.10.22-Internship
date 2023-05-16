package elizCurtnazar.tests.tema9.gridtema7;

//import elizCurtnazar.tests.tema7.BaseTest;
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
            remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/");
            WebElement menu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
            menu.click();
            WebElement loginLink = remoteWebDriver.findElement(By.linkText("Login"));
            loginLink.click();
            Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                    "Couldn't navigate to login page!");
            WebElement usernameInput = remoteWebDriver.findElement(By.name("username"));
            usernameInput.sendKeys("John Doe");
            WebElement passwordInput = remoteWebDriver.findElement(By.name("password"));
            passwordInput.sendKeys("ThisIsNotAPassword");
            WebElement loginButton = remoteWebDriver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    "Couldn't navigate to appointment page!");
    }

    @Test
    public void loginWithInvalidCredentials() {

        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement menu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement loginLink = remoteWebDriver.findElement(By.linkText("Login"));
        loginLink.click();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Couldn't navigate to login page!");
        WebElement usernameInput = remoteWebDriver.findElement(By.name("username"));
        usernameInput.sendKeys("John Do");
        WebElement passwordInput = remoteWebDriver.findElement(By.name("password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = remoteWebDriver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement unsuccessfulLoginMessage = remoteWebDriver.findElement(By.className("text-danger"));
        Assert.assertEquals(unsuccessfulLoginMessage.getText(),
                "Login failed! Please ensure the username and password are valid.",//obligatoriu
                "Shouldn't navigate to appointment page!");//optional
    }

    @Test(dataProvider = "loginDataProvider", groups = "login")
    public void loginWithCredentials(String username, String password, String credentialsType) {
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement menu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement loginLink = remoteWebDriver.findElement(By.linkText("Login"));
        loginLink.click();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Couldn't navigate to login page!");
        WebElement usernameInput = remoteWebDriver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = remoteWebDriver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        WebElement loginButton = remoteWebDriver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        if (credentialsType.equals("validCredentials")) {
            Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    "Couldn't navigate to appointment page!");
        } else {
            WebElement unsuccessfulLoginMessage = remoteWebDriver.findElement(By.className("text-danger"));
            Assert.assertEquals(unsuccessfulLoginMessage.getText(),
                    "Login failed! Please ensure the username and password are valid.",
                    "Shouldn't navigate to appointment page!");
        }
    }

    @Test(groups = "redirect")
    public void verifyRedirectToLoginWhenUserNotLoggedIn() {
        WebElement makeAppointmentButton = remoteWebDriver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "User is not redirected to login page when not logged in!");
    }

}
