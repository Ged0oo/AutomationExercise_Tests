package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterationSuccessPage {

    public WebDriver driver;
    public RegisterationSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");

    /**
     * Assertions
     */
    public void checkThatAccountCreatedSuccessfully() {
        WebElement successMessage = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(successMessage.getText().contains("ACCOUNT CREATED!"));
    }

}
