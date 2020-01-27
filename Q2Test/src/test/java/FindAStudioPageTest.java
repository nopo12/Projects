import PageObjects.FindAStudioPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FindAStudioPageTest extends BaseTestSetUp {
    private WebDriver driver;
    private FindAStudioPage fsp;

    @Parameters({"site2"})
    @BeforeClass
    public void setUp(String site2) {
        initTestBaseSetup(site2);
        driver = getDriver();
    }

    @Parameters({"findAStudioPageTitle"})
    @Test
    public void testFindAStudioPage(String findAStudioPageTitle) {
        fsp = new FindAStudioPage(driver);
        removePopUp();
        Assert.assertTrue(fsp.verifyFindAStudioPageTitle(findAStudioPageTitle), "Find A Studio title doesn't match");
        Assert.assertNotNull(fsp.searchZip());
    }

}
