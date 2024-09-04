package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

    By signUpMail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpName = By.xpath("//input[@data-qa=\"signup-name\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    By logInEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By logInPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By logInButton = By.xpath("//button[@data-qa=\"login-button\"]");

    public WebDriver driver;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Assertions
     */
    public void checkThatUserNavigatedToSignUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    /**
     * Actions
     */
    public void fillLoginForm(String email, String password) {
        driver.findElement(logInEmail).sendKeys(email);
        driver.findElement(logInPassword).sendKeys(password);
        driver.findElement(logInButton).click();
    }

    public void fillSignUpForm(String email, String name) {
        driver.findElement(signUpMail).sendKeys(email);
        driver.findElement(signUpName).sendKeys(name);
        driver.findElement(signUpButton).click();
    }
}
