package elizCurtnazar.tests.tema9.gridtema8.teste;

import elizCurtnazar.tests.tema8.pageObject.RefreshPage;
import elizCurtnazar.tests.tema8.teste.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshPageTests extends BaseTest {

    @Test(groups = {"mobile","desktop"})
    public void refreshPage() {
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.getTimeOfTheRefresh();
        System.out.println("Am intrat pe pagine de refresh si timpul este " + refreshPage.getTimeOfTheRefresh());
        driver.navigate().refresh();
        System.out.println("Am dat un refresh si timpul acum este " + refreshPage.getTimeOfTheRefresh());
        Assert.assertEquals(refreshPage.getTimeOfTheRefresh(), refreshPage.getTimeOfTheRefresh(), "Timpul intre refresh nu sa schimbat!");
    }
}
