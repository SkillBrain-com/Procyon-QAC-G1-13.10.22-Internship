package ancaMarian.tests.tema9.tema8.tests;

import ancaMarian.tests.tema9.tema8.pageObjects.RefreshPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RefreshPageTest extends BaseTest {

    @Test(groups = {"mobile", "desktop"})
    public void refreshPageTest() {
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.waitForIdToBeVisible();
        String timestampBeforeRefresh = refreshPage.getTimestamp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().refresh();
        String timestampAfterRefresh = refreshPage.getTimestamp();
        Assert.assertNotEquals(timestampAfterRefresh, timestampBeforeRefresh, "Timestamp did not change after refresh.");
    }
}
