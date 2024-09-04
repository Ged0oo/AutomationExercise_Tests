package tests;
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

    WebDriver driver;
    LoginSignupPage login;
    RegisterationSuccessPage successPage;
    Homepage homepage;
    RegisterationPage registerationPage;
    AcountDeletionPage delete;

    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();
        login = new LoginSignupPage(driver);
        successPage = new RegisterationSuccessPage(driver);
        homepage = new Homepage(driver);
        registerationPage = new RegisterationPage(driver);
        delete = new AcountDeletionPage(driver);
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        homepage.checkThatUserNavigatedToHomePage();
        homepage.clickOnSignUpLink();
        login.checkThatUserNavigatedToLogInSignUpPage();
        login.fillSignUpForm("al933@jfg.vv", "Mohamed Nagy");
        registerationPage.checkThatRegisterationPageLoaded();
        registerationPage.fillInAccountInformation("male", "al933@jfg.vv", "19919690mN@", "15", "6", "2001");
        registerationPage.fillInAddressInformation("Mohamed", "Nagy", "DEPI", "Alexandria", "Smouha", "Singapore", "Waly", "Maly", "22346", "01553158667");
        successPage.checkThatAccountCreatedSuccessfully();
        successPage.clickContinueButton();
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
        driver.navigate().to("https://automationexercise.com/login");
        login.fillLoginForm("ajkn0h@jfg.vv", "19919690mN@");
        homepage.checkThatUserLoggedInSuccessfully();
        homepage.checkThatLogoutLinkShouldBeDisplayed();
    }

    @Test(priority = 3, dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanDeleteAccountSuccessfully() {
        driver.navigate().to("https://automationexercise.com/");
        homepage.checkThatUserNavigatedToHomePage();
        homepage.checkThatUserLoggedInSuccessfully();
        homepage.checkThatLogoutLinkShouldBeDisplayed();
        homepage.clickOnDeleteAccountLink();
        delete.checkThatAccountDeletedSuccessfully();
        delete.clickContinueButton();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        //driver.quit();
    }

}
