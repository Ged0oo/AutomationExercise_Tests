package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCasesPage {

    /**
     * Constructor
     */
    public WebDriver driver;
    public TestCasesPage(WebDriver driver) {
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
        Assert.assertTrue(driver.getCurrentUrl().contains("/test_cases"));
        Assert.assertTrue(driver.findElement(loc_testCasesLabel).isDisplayed());
    }

    /**
     * Actions
     */
}

