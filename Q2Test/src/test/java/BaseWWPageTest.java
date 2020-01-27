import PageObjects.BaseWWPage;
import PageObjects.FindAStudioPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseWWPageTest extends BaseTestSetUp {
    private BaseWWPage bp;


    private WebDriver driver;
    //private String website = "https://www.weightwatchers.com/us/";

    @Parameters({ "site" })
    @BeforeClass
    public void setUp(String site) {
        initTestBaseSetup(site);
        driver = getDriver();
    }
    @Parameters({ "basePageTitle" })
    @Test
    public void testBaseTitle(String basePageTitle) {
        bp = new BaseWWPage(driver);
        //removePopUp();
        Assert.assertTrue( bp.verifyBasePageTitle(basePageTitle),"WW page title doesn't match");
    }
    @Test
    public void testStudioBtn(){
        bp = new BaseWWPage(driver);
        FindAStudioPage fsp = bp.clickFindAStudioBtn();
        //removePopUp();
        Assert.assertNotNull(fsp);
    }
}