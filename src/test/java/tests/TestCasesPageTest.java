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

public class TestCasesPageTest {

    Driver driver;
    Homepage homepage;
    TestCasesPage testCases;

    @BeforeClass
    public void setUp (){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new Driver("CHROME");
        homepage = new Homepage(driver);
        testCases = new TestCasesPage(driver);
        driver.get().navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanNavigateToTestCasesPageSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage()
                .checkThatUserNavigatedToHomePage()
                .clickOnTestCasesLink()
                .checkThatTestCasesPageLoadedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }

}
