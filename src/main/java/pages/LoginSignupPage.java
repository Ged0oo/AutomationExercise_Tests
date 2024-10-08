package pages;

import driverFactory.Driver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

    /**
     * Constructor
     */
    public Driver driver;
    public LoginSignupPage(Driver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By signUpMail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpName = By.xpath("//input[@data-qa=\"signup-name\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    By logInEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By logInPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By logInButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By newUserSignUpLabel = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    By logInYourAccountLabel = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
    By logInIncorrectCridentialsLabel = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    By existingMailAddressLabel = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

    /**
     * Assertions
     */
    public LoginSignupPage checkThatUserNavigatedToLogInSignUpPage() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/login"));
        Assert.assertTrue(driver.element().isDisplayed(newUserSignUpLabel));
        Assert.assertTrue(driver.element().isDisplayed(logInYourAccountLabel));
        return this;
    }

    public void checkThatUserCanNotLogInWithIncorrectCridentials() {
        Assert.assertTrue(driver.element().isDisplayed(logInIncorrectCridentialsLabel));
    }

    public void checkThatUserCanNotSignUpWithExistingAccount() {
        Assert.assertTrue(driver.element().isDisplayed(existingMailAddressLabel));
    }

    /**
     * Actions
     */
    public Homepage fillLoginForm(String email, String password) {
        driver.element().fillField(logInEmail, email);
        driver.element().fillField(logInPassword, password);
        driver.element().click(logInButton);
        return new Homepage(driver);
    }

    public RegisterationPage fillSignUpForm(String email, String name) {
        driver.element().fillField(signUpMail, email);
        driver.element().fillField(signUpName, name);
        driver.element().click(signUpButton);
        return new RegisterationPage(driver);
    }

    public void fillSignUpPage(String email, String name) {}
}
