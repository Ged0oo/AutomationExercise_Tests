package tests;
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

public class UserLogOut {

    private static final Logger log = LoggerFactory.getLogger(LogInWithCorrectCredintials.class);
    WebDriver driver;
    LoginSignupPage login;
    RegisterationSuccessPage successPage;
    Homepage homepage;
    RegisterationPage registerationPage;
    AcountDeletionPage delete;

    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();
        login = new LoginSignupPage(driver);
        successPage = new RegisterationSuccessPage(driver);
        homepage = new Homepage(driver);
        registerationPage = new RegisterationPage(driver);
        delete = new AcountDeletionPage(driver);
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanLoginSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage();
        homepage.clickOnSignUpLink();
        login.checkThatUserNavigatedToLogInSignUpPage();
        login.fillLoginForm("632273@jfg.vv", "19919690mN@");
        homepage.checkThatUserLoggedInSuccessfully();
    }

    @Test(priority = 2, dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanLogOutAccountSuccessfully() {
        driver.navigate().to("https://automationexercise.com/");
        homepage.checkThatUserNavigatedToHomePage();
        homepage.checkThatUserLoggedInSuccessfully();
        homepage.checkThatLogoutLinkShouldBeDisplayed();
        homepage.clickOnLogoutLink();
        login.checkThatUserNavigatedToLogInSignUpPage();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
