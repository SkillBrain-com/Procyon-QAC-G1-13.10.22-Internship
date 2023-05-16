package elizCurtnazar.tests.tema9.gridtema6;

import elizCurtnazar.driver.BrowserManager;
import elizCurtnazar.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.IOException;
import java.util.Set;

public class DemoQaWindow {

    static RemoteWebDriver remoteWebDriver = null;

    public static void main(String[] args) throws IOException {
        navigateToDemoQAWindowPage();
//        clickOnNewTabButton(); EXEMPLU DIN ORE
        clickNewTab();
        clickNewWindow();
//        clickNewWindowMessage();
        try {
            clickNewWindowMessage();
            System.out.println("Am intrat in blocul de try.");
        } catch (Exception | Error e) {
            System.out.println("Am prins o exceptie in blocul de catch.");
            FileUtils.takeScreenshot1(remoteWebDriver, "New Window Message");
            //alta varianta
//            File file = driver.getScreenshotAs(OutputType.FILE);
//            File destinationFile = new File("C:\\Users\\Deniz\\IdeaProjects\\poza3.png");
//            FileUtils.copyFile(file, destinationFile);
        } finally {
            closeBrowser();
            System.out.println("Am inchis pagina de pe blocu de finally.");
        }


    }

    public static void navigateToDemoQAWindowPage() {
        remoteWebDriver = BrowserManager.createDriver();
        remoteWebDriver.get("https://demoqa.com/browser-windows");
        System.out.println("Am deschis Demo QA window page!");
    }

    //EXEMPLU DIN ORE
//    public static void clickOnNewTabButton() {
//        //get parent tab id
//        String parentTab = driver.getWindowHandle();
//        WebElement newTabButton = driver.findElement(By.id("tabButton"));
//        //open new tab
//        newTabButton.click();
//        //get tab list ids
//        Set<String> tabs = driver.getWindowHandles();
//        for (String tab : tabs) {
//            //switch focus to new tab, get heading text and close the tab
//            if(!tab.equals(parentTab)) {
//                //switch focus to new tab
//                driver.switchTo().window(tab);
//                WebElement newTabHeading = driver.findElement(By.id("sampleHeading"));
//                System.out.println("Text de pe noul tab " + newTabHeading.getText());
//                driver.close();
//            }
//        }
//        //switch back to parent tab to be able to make other actions
//        driver.switchTo().window(parentTab);
//        System.out.println("Am facut click pe new tab button");
//    }

    public static void clickNewTab () {
        String parentTab = remoteWebDriver.getWindowHandle();
        WebElement newTab = remoteWebDriver.findElement(By.id("tabButton"));
        newTab.click();
        System.out.println("Am dat click pe New Tab.");

        Set<String> tabs = remoteWebDriver.getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(parentTab)) {
                remoteWebDriver.switchTo().window(tab);
                WebElement textNewTab = remoteWebDriver.findElement(By.id("sampleHeading"));
                System.out.println(textNewTab.getText());
                remoteWebDriver.close();
            }
        }
        remoteWebDriver.switchTo().window(parentTab);
        System.out.println("M-am intors pe  Demo QA window page.");
    }

    public static void clickNewWindow () {
        String parentTab2 = remoteWebDriver.getWindowHandle();
        WebElement newWindow = remoteWebDriver.findElement(By.id("windowButton"));
        newWindow.click();
        System.out.println("Am dat click pe New Window.");

        Set<String> tabs2 = remoteWebDriver.getWindowHandles();
        for (String tab : tabs2) {
            if (!tab.equals(parentTab2)) {
                remoteWebDriver.switchTo().window(tab);
                WebElement textNewTab = remoteWebDriver.findElement(By.id("sampleHeading"));
                System.out.println(textNewTab.getText());
                remoteWebDriver.close();
            }
        }
        remoteWebDriver.switchTo().window(parentTab2);
        System.out.println("M-am reintors pe Demo QA window page.");
    }

    public static void clickNewWindowMessage () {
        //nu am luat id selector pentru ca nu-mi rula. Daca iti aduci aminte ti-am mai spus ca am probleme cu PC ul.
        String parentTab3 = remoteWebDriver.getWindowHandle();
        WebElement newWindowMessage = remoteWebDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        newWindowMessage.click();
        System.out.println("Am dat click pe New Window Message.");

        Set<String> tabs3 = remoteWebDriver.getWindowHandles();
        for (String tab : tabs3) {
            if (!tab.equals(parentTab3)) {
                remoteWebDriver.switchTo().window(tab);
                WebElement textNewTab = remoteWebDriver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
                System.out.println(textNewTab.getText());
                remoteWebDriver.close();
            }
        }
        remoteWebDriver.switchTo().window(parentTab3);
        System.out.println("M-am reintors pe Demo QA window page.");
    }

    public static void closeBrowser() {
        remoteWebDriver.quit();
        System.out.println("Am inchis browserul!");
    }
}


//   String parentWindow =  driver.getWindowHandle(); //returneaza un id sau o lista a id urilor/a taburilor deschise cand metoda este apelata
//   Set<String> windowHandles = driver.getWindowHandles(); // set este ca o lista care contine elemente unice, nu duplicate.
//Nu putem accesa elementele pe baza index ului.
