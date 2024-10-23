package tests;
import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class ContactUsTest {
//    Driver driver;
    Homepage homepage;
    public ThreadLocal<Driver> driver;
    @BeforeClass
    @Parameters(value={"browser"})
    public void setUp (String browser){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ThreadLocal<>();
        driver.set(new Driver(browser));
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        homepage = new Homepage(driver.get());
        driver.get().browser().navigateToURL("https://automationexercise.com/");
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
        driver.get().browser().deleteAllCookie();
        driver.get().quit();
    }

}