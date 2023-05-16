package elizCurtnazar.tests.tema9.gridtema7;

//import elizCurtnazar.tests.tema7.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeButton extends BaseTest {

    @Test
    public void goToTheHomePage() {
        WebElement menu = remoteWebDriver.findElement(By.cssSelector(".btn-dark.btn-lg.toggle"));
        menu.click();
        WebElement homeButton = remoteWebDriver.findElement(By.xpath("/html/body/nav/ul/li[2]/a"));
        homeButton.click();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Am navigat in Home page!");
    }

    @Test
    public void loginPage() {
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        goToTheHomePage();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din Login page!");
    }

    @Test
    public void historyPage() {
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/history.php#history");
        goToTheHomePage();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din History page!");
    }

    @Test
    public void profilePage() {
        remoteWebDriver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        goToTheHomePage();
        Assert.assertEquals(remoteWebDriver.getCurrentUrl(),
                "https://katalon-demo-cura.herokuapp.com/",
                "Nu sa accesat Home page!");
        System.out.println("Am navigat in Home page din Profile page!");
    }
}
