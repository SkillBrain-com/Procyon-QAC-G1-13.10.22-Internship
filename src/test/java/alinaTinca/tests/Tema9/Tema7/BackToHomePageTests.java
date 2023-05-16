package alinatinca.tests.Tema9.Tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackToHomePageTests extends BaseTest {

//Ex 5
    public void goToMenuButtonAndClickHomeButton(){
        //create a method that go to menu button and clik on home button
        WebElement menuButton = remoteWebDriver.findElement(By.id("menu-toggle"));
        //find the menu button
        menuButton.click();
        //click on it
        WebElement homeButton = remoteWebDriver.findElement(By.xpath("//a[text()='Home']"));
        //find the home button
        homeButton.click();
        //click on it
    }

    @Test(description = "verify that return to home page from home page menu", groups = "homePage")
    public void backToHomePageFromHomePageMenu(){
        goToMenuButtonAndClickHomeButton();
        //go to menu button and clik on home button
        System.out.println("Back to home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
        //check if return to home page
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }

    //Method for precondition
    public void loginWithValidCredentials(){
        //create a method that is a precondition for login before doing any other operation
        WebElement menuButton = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        //find the Home Menu button
        menuButton.click();
        //click on home button
        WebElement loginLink = remoteWebDriver.findElement(By.linkText("Login"));
        //find the Login button
        loginLink.click();
        //click on Login button
        WebElement usernameInput = remoteWebDriver.findElement(By.name("username"));
        //find the username filed
        usernameInput.sendKeys("John Doe");
        //fill in the username field with the above username
        WebElement passwordInput = remoteWebDriver.findElement(By.name("password"));
        //find the password field
        passwordInput.sendKeys("ThisIsNotAPassword");
        //fill in password field with the above password
        WebElement loginButton = remoteWebDriver.findElement(By.cssSelector("button[type='submit']"));
        //find the login button
        loginButton.click();
        //click on login button
    }

    @Test(description = "verify that return to home page from login page", groups = "homePage")
    public void backToHomePageFromLoginPage(){
        loginWithValidCredentials();
        //precondition for login to return to home page
        goToMenuButtonAndClickHomeButton();
        //go to menu button and clik on home button
        System.out.println("Back to home page BUT the appointment form is displayed on the home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }

    @Test(description = "verify that return to home page from appointment form page", groups = "homePage")
    public void backToHomePageFromAppointmentFormPage(){
        loginWithValidCredentials();
        //precondition for login before to navigate to appointment page
        goToMenuButtonAndClickHomeButton();
        //go to menu button and clik on home button
        System.out.println("Back to home page BUT the appointment form is displayed on the home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }

    @Test(description = "verify that return to home page from history page", groups = "homePage")
    public void backToHomePageFromHistoryPage(){
        loginWithValidCredentials();
        //precondition for login before to navigate to history page
        WebElement homeMenu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        //find the Home Menu button
        homeMenu.click();
        //click on home button
        WebElement historyButton = remoteWebDriver.findElement(By.xpath("//a[text()='History']"));
        //find the history button
        historyButton.click();
        //click on it
        goToMenuButtonAndClickHomeButton();
        //go to menu button and clik on home button
        System.out.println("Back to home page BUT the appointment form is displayed on the home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }

    @Test(description = "verify that return to home page from profile page", groups = "homePage")
    public void backToHomePageFromProfilePage(){
        loginWithValidCredentials();
        //precondition for login before to navigate to profile page
        WebElement homeMenu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        //find the Home Menu button
        homeMenu.click();
        //click on home button
        WebElement profileButton = remoteWebDriver.findElement(By.xpath("//a[text()='Profile']"));
        //find the profile button
        profileButton.click();
        //click on it
        goToMenuButtonAndClickHomeButton();
        //go to menu button and clik on home button
        System.out.println("Back to home page BUT the appointment form is displayed on the home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }

    @Test(description = "verify that return to home page from logout page", groups = "homePage")
    public void backToHomePageFromLogoutPage(){
        loginWithValidCredentials();
        //precondition for login before to navigate to logout page
        WebElement homeMenu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        //find the Home Menu button
        homeMenu.click();
        //click on home button
        WebElement logoutButton = remoteWebDriver.findElement(By.xpath("//a[text()='Logout']"));
        //find the logout button
        logoutButton.click();
        //click on it
        System.out.println("Back to home page BUT the appointment form is displayed on the home page!");
        //display the above message
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Back to home page!");
    }
}