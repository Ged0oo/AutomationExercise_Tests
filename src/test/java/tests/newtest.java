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
import pages.Homepage;
import pages.LoginSignupPage;
import pages.RegisterationSuccessPage;

public class newtest {

    WebDriver driver;
    LoginSignupPage login;
    RegisterationSuccessPage successPage;
    Homepage homepage;

    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();
        login = new LoginSignupPage(driver);
        successPage = new RegisterationSuccessPage(driver);
        homepage = new Homepage(driver);
        driver.navigate().to("https://automationexercise.com/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {

        homepage.clickOnLoginLink();
        login.checkThatUserNavigatedToSignUpPage();
        login.fillSignUpForm("am0h@jfg.vv", "Mohamed Nagy");
        driver.findElement(By.cssSelector("input[id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"password\"]")).sendKeys("19919690mN@");

        Select day = new Select(driver.findElement(By.id("days")));
        Select month = new Select(driver.findElement(By.id("months")));
        Select year = new Select(driver.findElement(By.id("years")));

        day.selectByValue("15");
        month.selectByValue("6");
        year.selectByValue("2001");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.xpath("//input[@data-qa=\"first_name\"]")).sendKeys("Mohamed");
        driver.findElement(By.xpath("//input[@data-qa=\"last_name\"]")).sendKeys("Mohamed");
        driver.findElement(By.xpath("//input[@data-qa=\"company\"]")).sendKeys("DEPI");

        driver.findElement(By.cssSelector("input[data-qa=\"address\"]")).sendKeys("Alexandria, Smouha");
        driver.findElement(By.cssSelector("input[data-qa=\"address2\"]")).sendKeys("Behira, Kom Hamada");

        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("Singapore");

        driver.findElement(By.cssSelector("input[data-qa=\"state\"]")).sendKeys("Waly");
        driver.findElement(By.cssSelector("input[data-qa=\"city\"]")).sendKeys("maly");
        driver.findElement(By.cssSelector("input[data-qa=\"zipcode\"]")).sendKeys("22364");

        driver.findElement(By.xpath("//input[@data-qa=\"mobile_number\"]")).sendKeys("01553158667");
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();

        successPage.checkThatAccountCreatedSuccessfully();
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 2, dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully() {
        driver.navigate().to("https://automationexercise.com/login");
        login.fillLoginForm("am0h@jfg.vv", "19919690mN@");
        homepage.checkThatLogoutLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
