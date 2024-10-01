package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterationSuccessPage {

    /**
     * Constructor
     */
    public Driver driver;
    public RegisterationSuccessPage(Driver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    /**
     * Assertions
     */
    public RegisterationSuccessPage checkThatAccountCreatedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.get().findElement(successMessage).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public void clickContinueButton() {
        driver.get().findElement(continueButton).click();
    }
}
