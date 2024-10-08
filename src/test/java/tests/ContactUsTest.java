package tests;
import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class ContactUsTest {
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
    public void userCanContactSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .clickOnContactUsLink()
                .checkThatContactUsPageLoadedSuccessfully()
                .fillContactUsForm("Mohamed Nagy", "dfdsf@df.cc", "Objection", "HelloWorld How Are Things >>!")
                .userContactedUsSuccessfully().clickHome().checkThatUserNavigatedToHomePage();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookie();
        driver.quit();
    }

}
