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
        Assert.assertTrue(driver.findElement(logOutLink).isDisplayed());
        return this;
    }

    public Homepage checkThatUserNavigatedToHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }

    public Homepage checkThatUserLoggedInSuccessfully() {
        Assert.assertTrue(driver.findElement(logedInAs).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public LoginSignupPage clickOnSignUpLink(){
        driver.findElement(signUpLogInLink).click();
        return new LoginSignupPage(driver);
    }

    public void clickOnLogoutLink(){
        driver.findElement(logOutLink).click();
    }

    public AcountDeletionPage clickOnDeleteAccountLink(){
        driver.findElement(deletAccountLink).click();
        return new AcountDeletionPage(driver);
    }

    public ContactUsPage clickOnContactUsLink(){
        driver.findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickOnTestCasesLink(){
        driver.findElement(testCasesLink).click();
        return new TestCasesPage(driver);
    }

}
