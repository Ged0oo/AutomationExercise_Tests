package elementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {

    private WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions click(By locator) {
        driver.findElement(locator).click();
        return this;
    }

    public ElementActions fillField(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clear(By locator) {
        driver.findElement(locator).clear();
        return this;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
