package elizCurtnazar.tests.tema9.gridtema5;

import elizCurtnazar.driver.BrowserManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BothPagesTests {

    public static void main(String[] args) {
        RemoteWebDriver remoteWebDriver = BrowserManager.createRemoteWebDriver();

        DemoQaManager demoqaPage = new DemoQaManager("https://demoqa.com/elements", remoteWebDriver);

        demoqaPage.selectTextBox();
        demoqaPage.selectCheckBox();
        demoqaPage.selectRadioButton();
        demoqaPage.webTablesLink("webtables");
        demoqaPage.buttonsLink("buttons");
        demoqaPage.linkElementLink("links");


        TestPagesHerokuappManager herokuapp = new TestPagesHerokuappManager("https://testpages.herokuapp.com/styled/index.html", remoteWebDriver);

        herokuapp.goToTheFirstPage();
        herokuapp.goToTheSecondPage();
        herokuapp.goToTheThirdPage();
        herokuapp.goToTheFourthPage();


        // cand metoda este void putem returna direct in metoda. numai trebuia afisat si pe clasa de test.
        //cand are return afisam in clasa de test.

        BrowserManager.closeRemoteWebDriver(remoteWebDriver);

    }
}


