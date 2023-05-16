package alinatinca.tests.Tema9.Tema6;

import alinatinca.Utils.FileUtils;
import alinatinca.driver.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Ex-2
public class HerokuForms {

    static RemoteWebDriver remoteWebDriver = null;

    public static void main(String[] args) {

    //Test1
        navigateToHerokuFormsPage();
        firstParagraph();
        scrollToSubmitButton();
        closeBrowser();

    //Test2
        try{
            hiddenInputElement();
            //go to the hidden input element and identify the exception for it because is hidden
        }catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(remoteWebDriver, " New alert");
            //call this method and take a screenshot for exception with the above message
        }finally {
            remoteWebDriver.quit();
            //close the driver instance
        }

    //Test3
        navigateToHerokuFormsPage();
        fillFormDetails();
        closeBrowser();

    //Test4
        try{
            navigateToHerokuIndexPage();
            //go to the Heroku Index Page and identify the exception for goBackToTheForm button
        }catch (NoSuchElementException e) {
            FileUtils.takeScreenshot(remoteWebDriver, "new alert");
            //call this method and take the screenshot for exception with the above message
            System.out.println("It should take a screenshot for the exception identified");
            //display the above message
        }finally {
            closeBrowser();
            //close the driver instance
        }
    }

    public static void navigateToHerokuFormsPage(){
        remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create the driver instance
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        //go to the above URL
        System.out.println("Heroku HTML Form Example page has been opened!");
        //display the above message
    }

    public static void navigateToHerokuIndexPage(){
        remoteWebDriver = BrowserManager.createRemoteWebDriver();
        //create the driver instance
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/index.html");
        //go to the Heroku Index Page
        WebElement goBackToTheFormButton = remoteWebDriver.findElement(By.className("styled-click-button"));
        //find the goBackToTheForm button
        goBackToTheFormButton.click();
        //click on this button
    }

    public static void firstParagraph() {
        WebElement firstParagraph = remoteWebDriver.findElement(By.className("explanation"));
        //find the first paragraph
        System.out.println("The first paragraph has the following message: " + firstParagraph.getText());
        //display the message for the first paragraph
    }

    public static void scrollToSubmitButton() {
        WebElement submitButton = remoteWebDriver.findElement(By
                    .xpath("//input[@type='submit']"));
        //find the submit button
        Actions actions = new Actions(remoteWebDriver);
        //create an object of type Actions
        actions.moveToElement(submitButton).build().perform();
        //scroll to the submit button
        System.out.println("Scroll to the submit button");
        //display the above message
    }

    public static void fillFormDetails(){
        WebElement userName = remoteWebDriver.findElement(By.cssSelector("input[name='username']"));
        //find the Username field
        WebElement password = remoteWebDriver.findElement(By.cssSelector("input[name='password']"));
        //find the Password field
        WebElement textAreaComment = remoteWebDriver.findElement(By.cssSelector("textarea[name='comments']"));
        //find the TextArea Comment field
        WebElement fileUpload = remoteWebDriver.findElement(By.cssSelector("input[name='filename']"));
        //find the Filename field
        List <WebElement> checkBoxes = (List<WebElement>) remoteWebDriver.findElements(By.name("checkboxes[]"));
        //find the list for the Checkbox Items
        List <WebElement> radioButtons = (List<WebElement>) remoteWebDriver.findElements(By.name("radioval"));
        //find the list for the Radio Items
        Select multipleSelectValue = new Select(remoteWebDriver.findElement(By.name("multipleselect[]")));
        //find the list for Multiple Select Values
        Select dropdown = new Select(remoteWebDriver.findElement(By.name("dropdown")));
        //find the list for Dropdown
        WebElement submitButton = remoteWebDriver.findElement(By.cssSelector("input[type='submit']"));
        //find the submit button
        userName.click();
        //click on Username field
        userName.sendKeys("test_demo");
        //fill the Username field with the above text
        userName.sendKeys(Keys.TAB);
        //Go to the next field with TAB
        password.click();
        //click on Password field
        password.sendKeys("password_test");
        //fill the Password field with the above text
        password.sendKeys(Keys.TAB);
        //Go to the next field with TAB
        textAreaComment.click();
        //click on TextArea Comment field
        textAreaComment.clear();
        //clear the TextArea Comment field
        textAreaComment.sendKeys("comment_test");
        //fill the TextArea Comment field with the above text
        textAreaComment.sendKeys(Keys.TAB);
        //Go to the next field with TAB
        fileUpload.sendKeys(System.getProperty("user.dir") + "\\src\\test\\java\\alinatinca\\tests\\Tema6\\forUpload.txt");
        checkBoxes.get(1).click();
        //get the second item from the Checkbox Items list and click on it
        radioButtons.get(2).click();
        //get the third item from the Radio Items list and click on it
        multipleSelectValue.deselectAll();
        //deselect all the items from the Multiple Select Values list
        multipleSelectValue.selectByValue("ms1");
        //select the first item from the Multiple Select Values list
        multipleSelectValue.selectByValue("ms2");
        //select the second item from the Multiple Select Values list
        dropdown.selectByIndex(4);
        //select the third item from the Multiple Select Values list
        System.out.println("The Form has been filled!");
        //display the above message
        submitButton.click();
        //click on submit button
        System.out.println("The submit button has been opened!");
        //display the above message
        WebElement goBackToTheFormButton = remoteWebDriver.findElement(By.className("styled-click-button"));
        //find the goBackToTheForm button
        Actions actions = new Actions(remoteWebDriver);
        //create an object of type Actions
        actions.moveToElement(goBackToTheFormButton).build().perform();
        //scroll to the goBackToTheForm button
        System.out.println("Scroll to the last button on the page");
        //display the above message
        goBackToTheFormButton.click();
        //come back to the main page
        System.out.println("Came back to the main page!");
        //display the above message
    }

    public static void hiddenInputElement(){
        remoteWebDriver = BrowserManager.createChromeDriver();
        //create the driver instance
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/the_form_processor.php");
        //go to the Heroku Index Page
        WebElement hiddenInput = remoteWebDriver.findElement(By.xpath("//strong[text()='hiddenField']"));
        //find the hiddenInput element
        System.out.println(hiddenInput.getAttribute("value"));
        //get attribute by value for the hiddenInput element
    }

     public static void closeBrowser() {
         remoteWebDriver.quit();
        //close the driver instance
         System.out.println("The driver instance has been closed!");
         //display the above message
     }
}