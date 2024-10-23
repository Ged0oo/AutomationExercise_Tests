package tests;
import driverFactory.Driver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class ContactUsTest {
//    Driver driver;
    Homepage homepage;
    public ThreadLocal<Driver> driver;
    @BeforeClass
    @Parameters(value={"browser"})
    public void setUp (@Optional("CHROME") String browser){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ThreadLocal<>();
        driver.set(new Driver(browser));
//        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get().browser().navigateToURL("https://automationexercise.com/");
        homepage = new Homepage(driver.get());
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