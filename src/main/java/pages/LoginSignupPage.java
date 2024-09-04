package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

    /**
     * Constructor
     */
    public WebDriver driver;
    public LoginSignupPage(WebDriver driver) {
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

    /**
     * Assertions
     */
    public void checkThatUserNavigatedToLogInSignUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.findElement(newUserSignUpLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(logInYourAccountLabel).isDisplayed());
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

    public void fillSignUpPage(String email, String name) {}
}
