package neculaclaudiu.tests.seleniumpart1;

import neculaclaudiu.driver.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestPrimulSite {
    public static void main(String[] args) {
        testPrimulLink();
        testAlDoileaLink();
        testAlTreileaLink();
        testAlPatruleaLink();
    }
    public static void testPrimulLink(){
        ChromeDriver driver = ChromeDriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement BasicExampleLink = driver.findElement(By.id("basicpagetest"));
        BasicExampleLink.click();
        WebElement text1 = driver.findElement(By.cssSelector("div.page-navigation + h1"));
        System.out.println(text1.getText());

        WebElement text2 = driver.findElement(By.className("explanation"));
        System.out.println(text2.getText());

        WebElement text3 = driver.findElement(By.id("para1"));
        System.out.println(text3.getText());

        WebElement text4 = driver.findElement(By.id("para2"));
        System.out.println(text4.getText());

        List<WebElement> links = driver.findElements(By.cssSelector(".page-footer a"));
        for(int i = 0; i < links.size(); i++){
            links.get(i).click();
        }
        driver.quit();
    }

    public static void testAlDoileaLink(){
        ChromeDriver driver = ChromeDriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement ElementAtributeLink  = driver.findElement(By.id("elementattributestest"));
        ElementAtributeLink.click();
        WebElement text1 = driver.findElement(By.cssSelector(".page-navigation + h1"));
        System.out.println(text1.getText());
        WebElement text2 = driver.findElement(By.className("explanation"));
        System.out.println(text2.getText());
        WebElement text3 = driver.findElement(By.cssSelector(".explanation + h2"));
        System.out.println(text3.getText());
        WebElement text4 = driver.findElement(By.xpath("//*[@class='inline-explanation'][1]"));
        System.out.println(text4.getText());
        WebElement text5 = driver.findElement(By.xpath("//*[@class='centered'][1]"));
        System.out.println(text5.getText());
        WebElement text6 = driver.findElement(By.xpath("//h2[2]"));
        System.out.printf(text6.getText());
        WebElement text7 = driver.findElement(By.xpath("//*[@class=\"inline-explanation\"][2]"));
        System.out.printf(text7.getText());
        WebElement text8 = driver.findElement(By.id("jsattributes"));
        System.out.printf("\n" + text8.getText());
        WebElement button = driver.findElement(By.className("styled-click-button"));
        button.click();
        System.out.printf("\n" + button.getText());
        driver.quit();
    }

    public static void testAlTreileaLink(){
        ChromeDriver driver = ChromeDriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement LocatorsLink = driver.findElement(By.id("findbytest"));
        LocatorsLink.click();

        WebElement text1 = driver.findElement(By.xpath("//h1"));
        System.out.printf(text1.getText() + "\n");

        WebElement text2 = driver.findElement(By.className("explanation"));
        System.out.printf(text2.getText() + "\n");

        List<WebElement> paragraphList = driver.findElements(By.cssSelector(".specialDiv p"));
        for (int i = 0 ; i < paragraphList.size(); i++){
            System.out.printf(paragraphList.get(i).getText() + "\n");
        }

        List<WebElement> jumpList = driver.findElements(By.cssSelector(".linkDiv li"));
        for (int i = 0 ; i < jumpList.size() ; i++){
            jumpList.get(i).click();
            System.out.printf(jumpList.get(i).getText() + "\n");
        }
        driver.quit();
    }

    public static void testAlPatruleaLink(){
        ChromeDriver driver = ChromeDriverManager.createChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement tableTestPage = driver.findElement(By.id("tablestest"));
        tableTestPage.click();
        WebElement text1 = driver.findElement(By.cssSelector("div.page-body h1"));
        System.out.println(text1.getText());
        WebElement text2 = driver.findElement(By.cssSelector("div.explanation p"));
        System.out.println(text2.getText());
        WebElement text3 = driver.findElement(By.cssSelector("#mytable caption"));
        System.out.println(text3.getText());
        List<WebElement> tableRows = driver.findElements(By.xpath("//tr"));
        for (int i = 0 ; i<=tableRows.size(); i++){
            if(i == 1){
                List<WebElement> tableCollums = driver.findElements(By.xpath("//tr["+i+"]//th"));
                for(int j=0; j<tableCollums.size(); j++){
                    System.out.println(tableCollums.get(j).getText());
                }
            }
            else {
                List<WebElement> tableColums = driver.findElements(By.xpath("//tr["+i+"]//td"));
                for(int j=0; j<tableColums.size(); j++){
                    System.out.println(tableColums.get(j).getText());
                }
            }
        }
        driver.quit();
    }
}