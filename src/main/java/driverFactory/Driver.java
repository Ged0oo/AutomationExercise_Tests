package driverFactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public Driver(String driverType) {
        driver = getDriver(driverType).startDriver();
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

    public WebDriver get() {
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
