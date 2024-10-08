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
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/contact_us"));
        Assert.assertTrue(driver.element().isDisplayed(loc_contactUsPage));
        Assert.assertTrue(driver.element().isDisplayed(loc_keepOnTouchLabel));
        return this;
    }

    public ContactUsPage userContactedUsSuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(loc_contactUsSuccessfullLabel));
        return this;
    }

    /**
     * Actions
     */
    public ContactUsPage fillContactUsForm(String name, String email, String subject, String message) {
        driver.element().fillField(loc_name, name);
        driver.element().fillField(loc_email, email);
        driver.element().fillField(loc_subject, subject);
        driver.element().fillField(loc_message, message);
        driver.element().click(loc_submitButton);
        driver.get().switchTo().alert().accept();
        return  this;
    }

    public Homepage clickHome() {
        driver.element().click(loc_homeButton);
        return new Homepage(driver);
    }

    public ContactUsPage clickOnContactUsLink() {
        driver.element().click(loc_contactUsPage);
        return  this;
    }
}

