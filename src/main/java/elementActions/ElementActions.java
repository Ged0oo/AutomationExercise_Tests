package elementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public ElementActions selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
        return  this;
    }

    public ElementActions selectByValue(By locator, String val) {
        new Select(driver.findElement(locator)).selectByValue(val);
        return  this;
    }

    public String getTextOf(By locator) {
        return driver.findElement(locator).getText();
    }

    public Boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public Boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }
}
