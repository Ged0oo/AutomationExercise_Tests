package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AcountDeletionPage {
    /**
     * Constructor
     */
    public Driver driver;
    public AcountDeletionPage(Driver driver) {
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
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(accoutDeletedLabel));
        return this;
    }


    /**
     * Actions
     */
    public Homepage clickContinueButton() {
        driver.element().click(continueButton);
        return new Homepage(driver);
    }
}
