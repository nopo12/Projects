import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTestSetUp {
    private WebDriver driver;
    static String driverPath = "./chromedriver";


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String site) {
        driver = initChromeDriver(site);
    }

    /**
     * Helper class to remove WW popup that could mess up the Q2.test
     */
    public void removePopUp(){
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
    }

    private static WebDriver initChromeDriver(String site) {
        //System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(site);
        return driver;
    }

    public void initTestBaseSetup(String site) {
        try {
            setDriver(site);
        } catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
