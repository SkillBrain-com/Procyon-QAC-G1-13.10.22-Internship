package alinatinca.tests.Tema9.Tema8.tests;

import alinatinca.tests.Tema9.Tema8.pageObjects.RefreshPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshPageTest extends BaseTest{
    @Test(groups = {"mobile", "desktop"})
    public void refreshPage(){
        remoteWebDriver.get("https://testpages.herokuapp.com/styled/refresh");
        System.out.println("Refresh Test Page has been opened!");
        RefreshPage refreshPage = new RefreshPage(remoteWebDriver);
        System.out.println("Timestamp before regreshing is: " + refreshPage.getStatusForTimestamp());
        remoteWebDriver.navigate().refresh();
        System.out.println("The page has been refreshed!");
        System.out.println("Timestamp after refreshing is: " + refreshPage.getStatusForTimestamp());
        Assert.assertEquals(refreshPage.getStatusForTimestamp(), refreshPage.getStatusForTimestamp(), "Timestamp has been changed!");
        System.out.println("Check was done successfully!");
    }
}