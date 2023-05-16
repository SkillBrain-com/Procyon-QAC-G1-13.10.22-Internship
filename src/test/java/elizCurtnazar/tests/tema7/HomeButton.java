package elizCurtnazar.tests.tema7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeButton extends BaseTest {

    @Test
    public void goToTheHomePage() {
        WebElement menu = driver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement homeButton = driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a"));
        homeButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Am navigat in Home page!");
    }

    @Test
    public void loginPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        goToTheHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din Login page!");
    }

    @Test
    public void historyPage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/history.php#history");
        goToTheHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din History page!");
    }

    @Test
    public void profilePage() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        goToTheHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din Profile page!");
    }
}
