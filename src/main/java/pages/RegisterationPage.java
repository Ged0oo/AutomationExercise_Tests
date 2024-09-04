package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterationPage {

    /**
     * Constructor
     */
    public WebDriver driver;
    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Locators
     */
    By loc_EnterAccountInformationLabel = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
    By loc_idGenderMr = By.cssSelector("input[id=\"id_gender1\"]");
    By loc_idGenderMrs = By.cssSelector("input[id=\"id_gender2\"]");
    By loc_password = By.xpath("//input[@data-qa=\"password\"]");
    By loc_day = By.id("days");
    By loc_month = By.id("months");
    By loc_year = By.id("years");
    By loc_newsTeller = By.id("newsletter");
    By loc_option = By.id("optin");
    By loc_firstName = By.xpath("//input[@data-qa=\"first_name\"]");
    By loc_lastName = By.xpath("//input[@data-qa=\"last_name\"]");
    By loc_company = By.xpath("//input[@data-qa=\"company\"]");
    By loc_firstAddress = By.cssSelector("input[data-qa=\"address\"]");
    By loc_lastAddress = By.cssSelector("input[data-qa=\"address2\"]");
    By loc_country = By.id("country");
    By loc_state = By.cssSelector("input[data-qa=\"state\"]");
    By loc_city = By.cssSelector("input[data-qa=\"city\"]");
    By loc_zipCode = By.cssSelector("input[data-qa=\"zipcode\"]");
    By loc_mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By loc_createAccount = By.xpath("//button[@data-qa=\"create-account\"]");

    /**
     * Assertions
     */
    public void checkThatRegisterationPageLoaded() {
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
        Assert.assertTrue(driver.findElement(loc_EnterAccountInformationLabel).isDisplayed());
    }

    /**
     * Actions
     */
    public void fillInAccountInformation(String gender, String email, String password, String day, String month, String year) {

        if(gender.equals("male"))
            driver.findElement(loc_idGenderMr).click();
        else if(gender.equals("female"))
            driver.findElement(loc_idGenderMrs).click();

        driver.findElement(loc_password).sendKeys(password);

        Select sel_day = new Select(driver.findElement(loc_day));
        sel_day.selectByValue(day);

        Select sel_month = new Select(driver.findElement(loc_month));
        sel_month.selectByValue(month);

        Select sel_year = new Select(driver.findElement(loc_year));
        sel_year.selectByValue(year);

        driver.findElement(loc_newsTeller).click();
        driver.findElement(loc_option).click();
    }

    public void fillInAddressInformation(String firstName, String lastName, String company, String address_1, String address_2, String country, String state, String city, String zipCode, String mobile) {
        driver.findElement(loc_firstName).sendKeys(firstName);
        driver.findElement(loc_lastName).sendKeys(lastName);
        driver.findElement(loc_company).sendKeys(company);
        driver.findElement(loc_firstAddress).sendKeys(address_1);
        driver.findElement(loc_lastAddress).sendKeys(address_2);

        Select sel_country = new Select(driver.findElement(loc_country));
        sel_country.selectByValue(country);

        driver.findElement(loc_state).sendKeys(state);
        driver.findElement(loc_city).sendKeys(city);
        driver.findElement(loc_zipCode).sendKeys(zipCode);
        driver.findElement(loc_mobileNumber).sendKeys(mobile);

        driver.findElement(loc_createAccount).click();
    }

}
