package tests;
import driverFactory.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class RegisterUserWithExistingEmail {

    private static final Logger log = LoggerFactory.getLogger(RegisterUserWithExistingEmail.class);
    Driver driver;
    LoginSignupPage login;
    Homepage homepage;

    @BeforeClass
    public void setUp (){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        login = new LoginSignupPage(driver);
        homepage = new Homepage(driver);
        driver.get().navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanNotLoginSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnSignUpLink()
                .checkThatUserNavigatedToLogInSignUpPage()
                .fillSignUpForm("632273@jfg.vv", "Mohamed Nagy");
        login.checkThatUserCanNotSignUpWithExistingAccount();
    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }

}
