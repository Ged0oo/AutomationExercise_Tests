package tests;
import driverFactory.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.ScreenShotManager;

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
