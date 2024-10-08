package tests;
import driverFactory.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class LogInWithCorrectCredintials {

    private static final Logger log = LoggerFactory.getLogger(LogInWithCorrectCredintials.class);
    Driver driver;
    Homepage homepage;

    @BeforeClass
    public void setUp (){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new Driver("CHROME");
        homepage = new Homepage(driver);
        driver.browser().navigateToURL("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanLoginSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnSignUpLink()
                .checkThatUserNavigatedToLogInSignUpPage()
                .fillLoginForm("hjk56@jfg.vv", "19919690mN@")
                .checkThatUserLoggedInSuccessfully()
                .clickOnDeleteAccountLink()
                .checkThatAccountDeletedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookie();
        driver.quit();
    }

}
