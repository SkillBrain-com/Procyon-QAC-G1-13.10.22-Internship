package andreeaG.tests.tema9.tema8.pageTests;

import andreeaG.tests.tema9.tema8.pageObjects.RefreshPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshPageTest extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void refreshPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        RefreshPage refreshPage = new RefreshPage(driver);
        String firstTimestamp = refreshPage.firstTimestamp();
        driver.navigate().refresh();
        String afterRefreshTimestamp = refreshPage.firstTimestamp();
        Assert.assertNotEquals(firstTimestamp, afterRefreshTimestamp, "Timestamps are same after refresh");
    }
}
