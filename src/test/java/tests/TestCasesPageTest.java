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

public class TestCasesPageTest {

    WebDriver driver;
    LoginSignupPage login;
    RegisterationSuccessPage successPage;
    Homepage homepage;
    RegisterationPage registerationPage;
    AcountDeletionPage delete;
    ContactUsPage contact;
    TestCasesPage testCases;

    @BeforeClass
    public void setUp (){
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        login = new LoginSignupPage(driver);
        successPage = new RegisterationSuccessPage(driver);
        homepage = new Homepage(driver);
        registerationPage = new RegisterationPage(driver);
        delete = new AcountDeletionPage(driver);
        contact = new ContactUsPage(driver);
        testCases = new TestCasesPage(driver);
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanNavigateToTestCasesPageSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage();
        homepage.checkThatUserNavigatedToHomePage();
        homepage.clickOnTestCasesLink();
        testCases.checkThatTestCasesPageLoadedSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}