package ancaMarian.tests.tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuApp {
    private static String url;
    private static ChromeDriver driver = null;

    HerokuApp(String url, ChromeDriver driver){
        this.url = url;
        this.driver = driver;
        driver.get(url);
    }
    //first link
    public static void checkFirstLink(){
        WebElement firstLink = driver.findElement(By.id("basicpagetest"));
        firstLink.click();
    }

    public static String checkFirstLinkPageTitle(){
        WebElement firstLinkPageTitle = driver.findElement(By.cssSelector("div+h1"));
        return firstLinkPageTitle.getText();
    }

    public static String checkFirstLinkPageExplanation(){
        WebElement firstLinkPageExplanation = driver.findElement(By.className("explanation"));
        return firstLinkPageExplanation.getText();
    }

    public static String checkFirstLinkFirstParagraph(){
        WebElement firstLinkFirstParagraph = driver.findElement(By.id("para1"));
        return firstLinkFirstParagraph.getText();
    }

    public static String checkFirstLinkSecondParagraph(){
        WebElement firstLinkSecondParagraph = driver.findElement(By.id("para2"));
        return firstLinkSecondParagraph.getText();
    }

    public void returnToIndex(){
        WebElement returnToIndex = driver.findElement(By.linkText("Index"));
        returnToIndex.click();
    }
    //second link
    public static void checkSecondLink(){
        WebElement secondLink = driver.findElement(By.id("elementattributestest"));
        secondLink.click();
    }

    public static String checkSecondLinkPageTitle(){
        WebElement secondLinkPageTitle = driver.findElement(By.cssSelector("div h1"));
        return secondLinkPageTitle.getText();
    }

    public static String checkSecondLinkPageExplanation(){
        WebElement secondLinkPageExplanation = driver.findElement(By.className("explanation"));
        return secondLinkPageExplanation.getText();
    }

    public static String checkSecondLinkFirstParagraphTitle(){
        WebElement secondLinkFirstParagraphTitle = driver.findElement(By.cssSelector("div+h2"));
        return secondLinkFirstParagraphTitle.getText();
    }

    public static String checkSecondLinkFirstParagraph(){
        WebElement secondLinkFirstParagraph = driver.findElement(By.cssSelector(".inline-explanation:first-of-type"));
        return secondLinkFirstParagraph.getText();
    }

    public static String checkSecondLinkFirstParagraphAttributes(){
        WebElement secondLinkFirstParagraphAttributes = driver.findElement(By.cssSelector("#domattributes"));
        return secondLinkFirstParagraphAttributes.getText();
    }

    public static String checkSecondLinkSecondParagraphTitle(){
        WebElement secondLinkSecondParagraphTitle = driver.findElement(By.cssSelector("h2:last-of-type"));
        return secondLinkSecondParagraphTitle.getText();
    }

    public static String checkSecondLinkSecondParagraph(){
        WebElement secondLinkSecondParagraph = driver.findElement(By.cssSelector(".inline-explanation:last-of-type"));
        return secondLinkSecondParagraph.getText();
    }

    public static String checkSecondLinkSecondParagraphAttributes(){
        WebElement secondLinkSecondParagraphAttributes = driver.findElement(By.cssSelector("p#jsattributes"));
        return secondLinkSecondParagraphAttributes.getText();
    }

    public static void secondLinkClickButton(){
        WebElement secondLinkButton = driver.findElement(By.className("styled-click-button"));
        secondLinkButton.click();
        WebElement wasButtonClicked = driver.findElement(By.cssSelector("[custom-1='value-1']"));
        if (wasButtonClicked.getText().equals("This paragraph has dynamic attributes")) {
            System.out.println("The button was clicked");
        }
    }

    //third link
    public static void checkThirdLink(){
        WebElement thirdLink = driver.findElement(By.id("findbytest"));
        thirdLink.click();
    }

    public static String checkThirdLinkPageTitle(){
        WebElement thirdLinkPageTitle = driver.findElement(By.cssSelector("div+h1"));
        return thirdLinkPageTitle.getText();
    }

    public static String checkThirdLinkPageExplanation(){
        WebElement thirdLinkPageExplanation = driver.findElement(By.className("explanation"));
        return thirdLinkPageExplanation.getText();
    }

    public static void checkThirdLinkListOfParagraphs(){
        for (int i = 1; i < 42; i++){
            WebElement thirdLinkListOfParagraphs = driver.findElement(By.id("p"+i));
            System.out.println(thirdLinkListOfParagraphs.getText());
        }
    }

    public static void checkThirdLinkListOfLinks(){
        for (int i = 26; i < 51; i++){
            WebElement thirdLinkListOfLinks = driver.findElement(By.id("a"+i));
            System.out.println(thirdLinkListOfLinks.getText());
        }
    }
    //4th link
    public static void checkFourthLink(){
        WebElement fourthLink = driver.findElement(By.id("tablestest"));
        fourthLink.click();
    }

    public static String checkFourthLinkPageTitle(){
        WebElement fourthLinkPageTitle = driver.findElement(By.cssSelector("div h1"));
        return fourthLinkPageTitle.getText();
    }

    public static String checkFourthLinkPageExplanation(){
        WebElement fourthLinkPageExplanation = driver.findElement(By.className("explanation"));
        return fourthLinkPageExplanation.getText();
    }

    public static String checkFourthLinkTable(){
        WebElement fourthLinkTable = driver.findElement(By.id("mytable"));
        return fourthLinkTable.getText();
    }
}
