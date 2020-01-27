import PageObjects.SearchZipPage;
import PageObjects.WWStudioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchZipPageTest extends BaseTestSetUp {
    private WebDriver driver;
    private SearchZipPage szp;
    //private String titlePage;

    @Parameters({ "site3" })
    @BeforeClass
    public void setUp(String site3) {
        initTestBaseSetup(site3);
        driver = getDriver();
    }

    @Parameters({ "zipPageTitle" })
    @Test
    public void testZipPage(String zipPageTitle){
        szp = new SearchZipPage(driver);
        removePopUp();
        String titlePage = szp.getSearchZipPageTitle();
        Assert.assertEquals(zipPageTitle,titlePage);
        WWStudioPage wwsp = szp.findWWStudio();
        removePopUp();
        Assert.assertNotNull(wwsp);
        Assert.assertEquals(szp.getStudioTitle(),wwsp.getLocalName());
        Assert.assertEquals(szp.getStudioDistance(),"0.49 mi.");
    }


}
