package tests;
import driverFactory.Driver;
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
        driver = new Driver("CHROME");
        login = new LoginSignupPage(driver);
        homepage = new Homepage(driver);
        driver.browser().navigateToURL("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnSignUpLink()
                .checkThatUserNavigatedToLogInSignUpPage()
                .fillSignUpForm("11ww@jfg.vv", "Mohamed Nagy")
                .checkThatRegisterationPageLoaded()
                .fillInAccountInformation("male", "qoqo@jfg.vv", "19919690mN@", "15", "6", "2001")
                .fillInAddressInformation("Mohamed", "Nagy", "DEPI", "Alexandria", "Smouha", "Singapore", "Waly", "Maly", "22346", "01553158667")
                .checkThatAccountCreatedSuccessfully()
                .clickContinueButton();
        driver.browser().deleteAllCookie();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
        driver.browser().navigateToURL("https://automationexercise.com/login");
        login.fillLoginForm("11ww@jfg.vv", "19919690mN@")
                .checkThatUserLoggedInSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed();
    }

    @Test(priority = 3, dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanDeleteAccountSuccessfully() {
        driver.browser().navigateToURL("https://automationexercise.com/");
        homepage.checkThatUserNavigatedToHomePage()
                .checkThatUserLoggedInSuccessfully()
                .checkThatLogoutLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully()
                .clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookie();
        driver.quit();
    }

}
