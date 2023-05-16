package neculaclaudiu.tests.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class CuraHealthcareTest extends BaseTest{

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider(){
        return new Object[][] {
                {"John Doe", "ThisIsNotAPassword", "validLogin"},
                {"Claudiu", "ThisIsAPassword", "invalidLogin"}
        };
    }

    @DataProvider(name = "scenario")
        public Object[][] scenario(){
        return new Object[][]{
                {"10/01/2023", "Positive scenario", true},
                {"", "Negative scenario", false}
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginWithValidAndInvalidAccount(String username, String password, String type){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement expandButton = driver.findElement(By.cssSelector("a#menu-toggle i"));
        expandButton.click();
        WebElement loginButton = driver.findElement(By.cssSelector("a[href = \"profile.php#login\"]"));
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Could not navigate to login url");
        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys(password);
        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();
        if (type.equals("validLogin")){
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/#appointment",
                "Could not navigate to appoiment page ");
        } else {
            WebElement failToLoginMessage = driver.findElement(By.className("text-danger"));
            Assert.assertEquals(failToLoginMessage.getText(),
                    "Login failed! Please ensure the username and password are valid.",
                    "Should not navigate to appointment page");
        }
    }

    @Test
    public void redirectToLoginTest(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/profile.php#login",
                "Make appointment button did not redirect to login page");

    }

    @Test
    public void testHomeButton(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement expandButton = driver.findElement(By.cssSelector("a#menu-toggle i"));
        expandButton.click();
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/", "Home button is not working");
    }

    @Test(dataProvider = "scenario")
    public void positiveAndNegativeScenarioTest(String data, String comment, boolean type){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement expandButton = driver.findElement(By.cssSelector("a#menu-toggle i"));
        expandButton.click();
        WebElement loginButton = driver.findElement(By.cssSelector("a[href = \"profile.php#login\"]"));
        loginButton.click();
        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        usernameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();
        WebElement dataInput = driver.findElement(By.id("txt_visit_date"));
        dataInput.sendKeys(data);
        WebElement commentInput = driver.findElement(By.id("txt_comment"));
        commentInput.sendKeys(comment);
        WebElement bookAppointment = driver.findElement(By.id("btn-book-appointment"));
        bookAppointment.click();
        if(type == true){
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/appointment.php#summary",
                    "Bookappointment did not work with valid imputs");
        }else {
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://katalon-demo-cura.herokuapp.com/#appointment",
                    "Bookappointment work with invalid imputs");
        }
    }

}
