package pages;
import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCasesPage {

    /**
     * Constructor
     */
    public Driver driver;
    public TestCasesPage(Driver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By loc_testCasesLabel = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");

    /**
     * Assertions
     */
    public void checkThatTestCasesPageLoadedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/test_cases"));
        Assert.assertTrue(driver.get().findElement(loc_testCasesLabel).isDisplayed());
    }

    /**
     * Actions
     */
}

