package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        Assert.assertTrue(driver.get().findElement(logOutLink).isDisplayed());
        return this;
    }

    public Homepage checkThatUserNavigatedToHomePage() {
        Assert.assertEquals(driver.get().getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }

    public Homepage checkThatUserLoggedInSuccessfully() {
        Assert.assertTrue(driver.get().findElement(logedInAs).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public LoginSignupPage clickOnSignUpLink(){
        driver.get().findElement(signUpLogInLink).click();
        return new LoginSignupPage(driver);
    }

    public void clickOnLogoutLink(){
        driver.get().findElement(logOutLink).click();
    }

    public AcountDeletionPage clickOnDeleteAccountLink(){
        driver.get().findElement(deletAccountLink).click();
        return new AcountDeletionPage(driver);
    }

    public ContactUsPage clickOnContactUsLink(){
        driver.get().findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickOnTestCasesLink(){
        driver.get().findElement(testCasesLink).click();
        return new TestCasesPage(driver);
    }

}
