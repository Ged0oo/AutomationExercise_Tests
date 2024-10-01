package tests;
import driverFactory.Driver;
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

public class newtest {

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
    public void userCanRegisterSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnSignUpLink()
                .checkThatUserNavigatedToLogInSignUpPage()
                .fillSignUpForm("dsdskkd@jfg.vv", "Mohamed Nagy")
                .checkThatRegisterationPageLoaded()
                .fillInAccountInformation("male", "al933@jfg.vv", "19919690mN@", "15", "6", "2001")
                .fillInAddressInformation("Mohamed", "Nagy", "DEPI", "Alexandria", "Smouha", "Singapore", "Waly", "Maly", "22346", "01553158667")
                .checkThatAccountCreatedSuccessfully()
                .clickContinueButton();
        driver.get().manage().deleteAllCookies();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
        driver.get().navigate().to("https://automationexercise.com/login");
        login.fillLoginForm("dsdskkd@jfg.vv", "19919690mN@")
                .checkThatUserLoggedInSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed();
    }

    @Test(priority = 3, dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanDeleteAccountSuccessfully() {
        driver.get().navigate().to("https://automationexercise.com/");
        homepage.checkThatUserNavigatedToHomePage()
                .checkThatUserLoggedInSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }

}
