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
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.get().findElement(newUserSignUpLabel).isDisplayed());
        Assert.assertTrue(driver.get().findElement(logInYourAccountLabel).isDisplayed());
        return this;
    }

    public void checkThatUserCanNotLogInWithIncorrectCridentials() {
        Assert.assertTrue(driver.get().findElement(logInIncorrectCridentialsLabel).isDisplayed());
    }

    public void checkThatUserCanNotSignUpWithExistingAccount() {
        Assert.assertTrue(driver.get().findElement(existingMailAddressLabel).isDisplayed());
    }

    /**
     * Actions
     */
    public Homepage fillLoginForm(String email, String password) {
        driver.get().findElement(logInEmail).sendKeys(email);
        driver.get().findElement(logInPassword).sendKeys(password);
        driver.get().findElement(logInButton).click();
        return new Homepage(driver);
    }

    public RegisterationPage fillSignUpForm(String email, String name) {
        driver.get().findElement(signUpMail).sendKeys(email);
        driver.get().findElement(signUpName).sendKeys(name);
        driver.get().findElement(signUpButton).click();
        return new RegisterationPage(driver);
    }

    public void fillSignUpPage(String email, String name) {}
}
