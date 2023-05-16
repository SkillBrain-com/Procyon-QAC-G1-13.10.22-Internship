package andreeaG.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnToHomeButton extends BaseTest{


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
