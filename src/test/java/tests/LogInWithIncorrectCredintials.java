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

public class LogInWithIncorrectCredintials {

    private static final Logger log = LoggerFactory.getLogger(LogInWithCorrectCredintials.class);
    Driver driver;
    LoginSignupPage login;
    Homepage homepage;

    @BeforeClass
    public void setUp (){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new Driver("CHROME");
        login = new LoginSignupPage(driver);
        homepage = new Homepage(driver);
        driver.browser().navigateToURL("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanNotLoginSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnSignUpLink()
                .checkThatUserNavigatedToLogInSignUpPage()
                .fillLoginForm("al933@jfg.vv", "45454545");
        login.checkThatUserCanNotLogInWithIncorrectCridentials();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookie();
        driver.quit();
    }

}
