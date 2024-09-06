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

    /**
     * Assertions
     */
    public void checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logOutLink).isDisplayed());
    }

    public void checkThatUserNavigatedToHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }

    public void checkThatUserLoggedInSuccessfully() {
        Assert.assertTrue(driver.findElement(logedInAs).isDisplayed());
    }

    /**
     * Actions
     */
    public void clickOnSignUpLink(){
        driver.findElement(signUpLogInLink).click();
    }

    public void clickOnLogoutLink(){
        driver.findElement(logOutLink).click();
    }

    public void clickOnDeleteAccountLink(){
        driver.findElement(deletAccountLink).click();
    }

    public void clickOnContactUsLink(){
        driver.findElement(contactUsLink).click();
    }

}
