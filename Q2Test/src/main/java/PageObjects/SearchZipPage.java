package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchZipPage {

    private WebDriver driver;
    private By locationDistance = By.className("location__distance");
    private By wwStudioLocations = By.className("meeting-location");
    private String studioDistance;
    private String studioTitle;

    public SearchZipPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getStudioDistance() {
        return studioDistance;
    }

    public String getStudioTitle() {
        return studioTitle;
    }

    public String getSearchZipPageTitle() {
        return driver.getTitle();
    }

    /**
     * Verify loaded page title contains correct title
     * @return true if so and false if not
     */
    public boolean verifyFindAStudioPageTitle(String expectedTitle) {
        return getSearchZipPageTitle().contains(expectedTitle);
    }


    /**
     * Click on the first search result
     * @return
     */
    public WWStudioPage findWWStudio() {
        WebElement wwStudioElement = driver.findElement(wwStudioLocations);
        WebElement wwStudioDistance = driver.findElement(locationDistance);
        /*
         * Prints the title of the first result(WW Studio) and the distance
         * (located on the right of location title/name) of it already searched by zip
         */
        studioDistance = wwStudioDistance.getText();
        studioTitle = wwStudioElement.getText().split("\n")[0];

        System.out.println("WW Studio Location: " + studioTitle);
        System.out.println("WW Studio Distance: " + studioDistance);

        System.out.println("Clicking First WW Studio: ");
        if(wwStudioElement.isDisplayed() || wwStudioElement.isEnabled()){
            wwStudioElement.click();
        } else {
            System.err.println("ERROR: Element not found");
            return null;
        }
        return new WWStudioPage(driver);
    }

}
