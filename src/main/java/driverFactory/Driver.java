package driverFactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import pages.Homepage;

public class Driver {

    public Homepage homepage;
    private ThreadLocal<WebDriver> driver;

    public Driver(String driverType) {

        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
        assert undecoratedDriver != null;

        driver = new ThreadLocal<>();
        driver.set( new EventFiringDecorator<>(WebDriver.class,
                new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver));

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

    public WebDriver get() {
        return driver.get();
    }

    public void quit() {
        driver.get().quit();
    }

    public ElementActions element() {
        return new ElementActions(driver.get());
    }
    public BrowserActions browser() {return new BrowserActions(driver.get());}
}
