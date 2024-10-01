package pages;
import driverFactory.Driver;
import elementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactUsPage {

    /**
     * Constructor
     */
    public Driver driver;
//    public WebDriver driver;
    public ContactUsPage(Driver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By loc_contactUsPage = By.xpath("//*[@id=\"contact-page\"]/div[1]/div/div/h2");
    By loc_keepOnTouchLabel = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By loc_name = By.xpath("//input[@data-qa=\"name\"]");
    By loc_email = By.xpath("//input[@data-qa=\"email\"]");
    By loc_subject = By.xpath("//input[@data-qa=\"subject\"]");
    By loc_message = By.xpath("//textarea[@data-qa=\"message\"]");
    By loc_upload = By.xpath("(//input[@class=\"form-control\"])[4]");
    By loc_submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");
    By loc_contactUsSuccessfullLabel = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    By loc_homeButton = By.xpath("//*[@id=\"form-section\"]/a");

    /**
     * Assertions
     */
    public ContactUsPage checkThatContactUsPageLoadedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/contact_us"));
        Assert.assertTrue(driver.get().findElement(loc_contactUsPage).isDisplayed());
        Assert.assertTrue(driver.get().findElement(loc_keepOnTouchLabel).isDisplayed());
        return this;
    }

    public ContactUsPage userContactedUsSuccessfully(){
        Assert.assertTrue(driver.get().findElement(loc_contactUsSuccessfullLabel).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public ContactUsPage fillContactUsForm(String name, String email, String subject, String message) {
        driver.get().findElement(loc_name).sendKeys(name);
        driver.get().findElement(loc_email).sendKeys(email);
        driver.get().findElement(loc_subject).sendKeys(subject);
        driver.get().findElement(loc_message).sendKeys(message);
        driver.get().findElement(loc_submitButton).click();
        driver.get().switchTo().alert().accept();
        return  this;
    }

    public Homepage clickHome() {
        driver.get().findElement(loc_homeButton).click();
        return new Homepage(driver);
    }

    public ContactUsPage clickOnContactUsLink() {
        driver.get().findElement(loc_contactUsPage).click();
        return  this;
    }
}

