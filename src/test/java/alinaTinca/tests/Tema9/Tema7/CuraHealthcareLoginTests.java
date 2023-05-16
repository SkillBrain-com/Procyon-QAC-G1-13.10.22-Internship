package alinatinca.tests.Tema9.Tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CuraHealthcareLoginTests extends BaseTest {

    @DataProvider(name="loginDataProvider")
    public Object[][] loginDataProvider(){
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword", "validCredentials"},
                //test case with valid credentials - test passed!
                {"Joh Doe", "ThisIsNotAPassword", "invalidCredentials"}
                //test case with invalid credentials - test failed!
        };
    }

//Ex1, Ex2
    @Test(dataProvider = "loginDataProvider", description = "verify login scenarios with valid and invalid data", groups = "login")
    public void loginWithCredentials(String username, String password, String credentialsType){
        WebElement menuButton = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        //find the Home Menu button
        menuButton.click();
        //click on home button
        WebElement loginLink = remoteWebDriver.findElement(By.linkText("Login"));
        //find the Login button
        loginLink.click();
        //click on Login button
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                //display login page after the login button has been opened
                "Couldn't navigate to login page!");
        //check if the user is redirected to login page when logged in and display an error message if the login button has been opened
        WebElement usernameInput = remoteWebDriver.findElement(By.name("username"));
        //find the username filed
        usernameInput.sendKeys(username);
        //fill in the username field with the above username
        WebElement passwordInput = remoteWebDriver.findElement(By.name("password"));
        //find the password field
        passwordInput.sendKeys(password);
        //fill in password field with the above password
        WebElement loginButton = remoteWebDriver.findElement(By.cssSelector("button[type='submit']"));
        //find the login button
        loginButton.click();
        //click on login button
        if(credentialsType.equals("validCredentials")) {
            //if credentials are valid
            Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
            //check if the user is redirected to appointment page and display a warning message if login is not successfully
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    //display appoitment page after login is successfully
                    "Couldn't navigate to login page!");
                    //display a warning message
            }else{
                WebElement unsuccessfullLoginMesagge = remoteWebDriver.findElement(By.className("text-danger"));
                //else find the red message that appears when login is not successfully
                Assert.assertEquals(unsuccessfullLoginMesagge.getText(),
                //check if the red message appears after the login is not successfully
                "Login failed! Please ensure the username and password are valid.",
                //and display the red message that appears when login is not successfully
                "Shouldn't navigate to appointment page!");
                //display a warning message
        }
    }

//Ex3
    @Test(description = "verify that user is redirected to login page when wants to make an appointment", groups = "redirect")
    public void verifyRedirectToLoginWhenUserNotLoggedIn(){
        WebElement makeAppoitmentButton = remoteWebDriver.findElement(By.id("btn-make-appointment"));
        //find the make appointment button
        makeAppoitmentButton.click();
        //click on appointment button
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),  //CurentURL = pagina cu login
        //check if the user can make an appoitment if not logged in
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                //display the login page when the user is not logged in
                "User is not redirected to login page when not logged in!");
                //display a warning message
    }
}