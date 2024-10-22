package driverFactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;


public class Driver {

    private static WebDriver driver;

    public Driver(String driverType) {

        WebDriver undecoratedDriver = getDriver(driverType).startDriver();

        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver);

        assert driver != null;
    }

    private DriverAbstract getDriver(String driverType) {
        switch (driverType) {
            case "CHROME" : {
                return new ChromeDriverFactory();
            }
            case "EDGE" : {
                return new EdgeDriverFactory();
            }
            default:{
                throw new IllegalStateException("Unexpected" + driverType);
            }
        }
    }

    public static WebDriver get() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }
    public BrowserActions browser() {return new BrowserActions(driver);}
}
