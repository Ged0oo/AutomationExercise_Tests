package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AcountDeletionPage {
    /**
     * Constructor
     */
    public WebDriver driver;
    public AcountDeletionPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By accoutDeletedLabel = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    /**
     * Assertions
     */
    public AcountDeletionPage checkThatAccountDeletedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.findElement(accoutDeletedLabel).isDisplayed());
        return this;
    }


    /**
     * Actions
     */
    public Homepage clickContinueButton() {
        driver.findElement(continueButton).click();
        return new Homepage(driver);
    }
}
