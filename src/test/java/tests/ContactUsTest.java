package tests;
import driverFactory.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class ContactUsTest {
    Driver driver;
    Homepage homepage;

    ThreadLocal<Driver> parallelDriver;
    @BeforeClass
    @Parameters(value={"browser"})
    public void setUp (String browser){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new Driver(browser);
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

//    @AfterMethod
//    public void checkFailure(ITestResult result) {
//         if(result.getStatus() == ITestResult.FAILURE) {
//             System.out.println("Test Failed.");
//             System.out.println("Taking Screenshot ...");
//             ScreenShotManager.captureScreenshot(driver.get(), "ContactUsTest");
//         }
//    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookie();
        driver.quit();
    }

}
