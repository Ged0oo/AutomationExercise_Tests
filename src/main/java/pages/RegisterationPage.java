package pages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterationPage {

    /**
     * Constructor
     */
    public Driver driver;
    public RegisterationPage(Driver driver) {
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
    public RegisterationPage checkThatRegisterationPageLoaded() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("signup"));
        Assert.assertTrue(driver.get().findElement(loc_EnterAccountInformationLabel).isDisplayed());
        return this;
    }

    /**
     * Actions
     */
    public RegisterationPage fillInAccountInformation(String gender, String email, String password, String day, String month, String year) {

        if(gender.equals("male"))
            driver.get().findElement(loc_idGenderMr).click();
        else if(gender.equals("female"))
            driver.get().findElement(loc_idGenderMrs).click();

        driver.get().findElement(loc_password).sendKeys(password);

        Select sel_day = new Select(driver.get().findElement(loc_day));
        sel_day.selectByValue(day);

        Select sel_month = new Select(driver.get().findElement(loc_month));
        sel_month.selectByValue(month);

        Select sel_year = new Select(driver.get().findElement(loc_year));
        sel_year.selectByValue(year);

        driver.get().findElement(loc_newsTeller).click();
        driver.get().findElement(loc_option).click();

        return this;
    }

    public RegisterationSuccessPage fillInAddressInformation(String firstName, String lastName, String company, String address_1, String address_2, String country, String state, String city, String zipCode, String mobile) {
        driver.get().findElement(loc_firstName).sendKeys(firstName);
        driver.get().findElement(loc_lastName).sendKeys(lastName);
        driver.get().findElement(loc_company).sendKeys(company);
        driver.get().findElement(loc_firstAddress).sendKeys(address_1);
        driver.get().findElement(loc_lastAddress).sendKeys(address_2);

        Select sel_country = new Select(driver.get().findElement(loc_country));
        sel_country.selectByValue(country);

        driver.get().findElement(loc_state).sendKeys(state);
        driver.get().findElement(loc_city).sendKeys(city);
        driver.get().findElement(loc_zipCode).sendKeys(zipCode);
        driver.get().findElement(loc_mobileNumber).sendKeys(mobile);

        driver.get().findElement(loc_createAccount).click();

        return new RegisterationSuccessPage(driver);
    }

}
