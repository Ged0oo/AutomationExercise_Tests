package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterationSuccessPage {

    /**
     * Constructor
     */
    public WebDriver driver;
    public RegisterationSuccessPage(WebDriver driver) {
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
        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
