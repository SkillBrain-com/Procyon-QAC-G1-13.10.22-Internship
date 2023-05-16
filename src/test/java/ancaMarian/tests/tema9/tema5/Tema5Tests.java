package ancaMarian.tests.tema9.tema5;

import ancaMarian.driver.BrowserManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Tema5Tests {
    public static void main(String[] args) {
        RemoteWebDriver driver = BrowserManager.createRemoteWebDriver();
        //primul Link din tema de pe platforma
        checkFirstPage(driver);
//        //al doilea link din platforma
        checkSecondPage(driver);
    }

    public static void checkFirstPage(RemoteWebDriver driver){
        HerokuApp page = new HerokuApp("https://testpages.herokuapp.com/styled/index.html", driver);
        BrowserManager.maximizeRemoteWebDriverWindow(driver);
        page.checkFirstLink();
        System.out.println(page.checkFirstLinkPageTitle());
        System.out.println(page.checkFirstLinkPageExplanation());
        System.out.println(page.checkFirstLinkFirstParagraph());
        System.out.println(page.checkFirstLinkSecondParagraph());
        page.returnToIndex();
        page.checkSecondLink();
        System.out.println(page.checkSecondLinkPageTitle());
        System.out.println(page.checkSecondLinkPageExplanation());
        System.out.println(page.checkSecondLinkFirstParagraphTitle());
        System.out.println(page.checkSecondLinkFirstParagraph());
        System.out.println(page.checkSecondLinkFirstParagraphAttributes());
        System.out.println(page.checkSecondLinkSecondParagraphTitle());
        System.out.println(page.checkSecondLinkSecondParagraph());
        System.out.println(page.checkSecondLinkSecondParagraphAttributes());
        page.secondLinkClickButton();
        page.returnToIndex();
        page.checkThirdLink();
        System.out.println(page.checkThirdLinkPageTitle());
        System.out.println(page.checkThirdLinkPageExplanation());
        page.checkThirdLinkListOfParagraphs();
        page.checkThirdLinkListOfLinks();
        page.returnToIndex();
        page.checkFourthLink();
        System.out.println(page.checkFourthLinkPageTitle());
        System.out.println(page.checkFourthLinkPageExplanation());
        System.out.println(page.checkFourthLinkTable());
    }

    public static void checkSecondPage(RemoteWebDriver driver){
        DemoQA page2 = new DemoQA("https://demoqa.com/elements", driver);
        page2.checkTextBox();
        page2.enterFullName();
        page2.enterEmail();
        page2.enterCurrentAddress();
        page2.enterPermanentAddress();
        page2.submitButton();
        page2.checkCheckBox();
        page2.homeFolder();
        page2.expand();
        page2.deselect();
        page2.collapse();
        page2.checkRadioButton();
        page2.clickRadioButton();
        page2.checkWebTables();
        page2.addNewRecord();
        page2.addFirstName();
        page2.addLastName();
        page2.addEmail();
        page2.addAge();
        page2.addSalary();
        page2.addDepartment();
        page2.clickSubmitButton();
        page2.useSearchBar();
        page2.edit();
        page2.delete();
        page2.buttons();
        page2.doubleClick();
        page2.rightClick();
        page2.clickButton();
        page2.links();
        page2.openFirstLink();
        BrowserManager.closeRemoteWebDriver(driver);
    }
}
