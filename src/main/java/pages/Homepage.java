package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Homepage {
    /**
     * Constructor
     */
    public WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By logInLink = By.xpath("//a[@href='/login']");
    By logOutLink = By.xpath("//a[@href='/logout']");
    By registerLink = By.xpath("//a[@href='/register']");
    By deletAccountLink = By.xpath("//a[@href=\"/delete_account\"]\n");

    /**
     * Assertions
     */
    public void checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logOutLink).isDisplayed());
    }

    /**
     * Actions
     */
    public void clickOnLoginLink(){
        driver.findElement(logInLink).click();
    }

    public void clickOnLogoutLink(){
        driver.findElement(logOutLink).click();
    }

}
