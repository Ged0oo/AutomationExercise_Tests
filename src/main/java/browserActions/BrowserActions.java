package browserActions;

import com.beust.ah.A;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BrowserActions {

    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions navigateToURL(String url) {
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions getToURL(String url) {
        driver.get(url);
        return this;
    }

    public String getCurrentURL() {
        return  driver.getCurrentUrl();
    }

    public BrowserActions navigateForward() {
        driver.navigate().forward();
        return this;
    }

    public BrowserActions navigateBackward() {
        driver.navigate().back();
        return this;
    }

    public BrowserActions refreshCurrentPage() {
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions scrollButtom() {
        new Actions(driver).scrollByAmount(0, 2500).build().perform();
        return this;
    }

    public BrowserActions scrollAmount(int weidth, int height) {
        new Actions(driver).scrollByAmount(weidth,height).build().perform();
        return this;
    }

    public BrowserActions addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public BrowserActions deleteAllCookie() {
        driver.manage().deleteAllCookies();
        return this;
    }

    public BrowserActions deleteCookieNamed(String cookie) {
        driver.manage().deleteCookieNamed(cookie);
        return this;
    }

}
