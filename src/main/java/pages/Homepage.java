package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Homepage {
    /**
     * Constructor
     */
    public Driver driver;
    public Homepage(Driver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By signUpLogInLink = By.xpath("//a[@href='/login']");
    By logOutLink = By.xpath("//a[@href='/logout']");
    By registerLink = By.xpath("//a[@href='/register']");
    By deletAccountLink = By.xpath("//a[@href=\"/delete_account\"]\n");
    By logedInAs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By testCasesLink = By.xpath("//a[@href=\"/test_cases\"]");

    /**
     * Assertions
     */
    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logOutLink));
        return this;
    }

    public Homepage checkThatUserNavigatedToHomePage() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://automationexercise.com/");
        return this;
    }

    public Homepage checkThatUserLoggedInSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(logedInAs));
        return this;
    }

    /**
     * Actions
     */
    public LoginSignupPage clickOnSignUpLink(){
        driver.element().click(signUpLogInLink);
        return new LoginSignupPage(driver);
    }

    public void clickOnLogoutLink(){driver.element().click(logOutLink);}

    public AcountDeletionPage clickOnDeleteAccountLink(){
        driver.element().click(deletAccountLink);
        return new AcountDeletionPage(driver);
    }

    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickOnTestCasesLink(){
        driver.element().click(testCasesLink);
        return new TestCasesPage(driver);
    }

}
