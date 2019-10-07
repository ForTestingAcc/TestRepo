package page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 60);
        this.js = (JavascriptExecutor) driver;
    }

    void waitFor(long mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void moveToElement(By locator, int xOffset, int yOffset) {
        waitForElementPresent(locator);
        Actions builder = new Actions(driver);
        builder.moveToElement(getWebElement(locator), xOffset, yOffset).build().perform();
    }

    protected void waitForElementToBeClickable(By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementPresent(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    protected void clickButton(By locator) {
        waitForElementPresent(locator);
        waitForElementToBeClickable(locator);
        getWebElement(locator).click();
    }

    protected void clickButton(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void writeTextToField(By locator, String text) {
        waitForElementPresent(locator);
        waitForVisibleElement(locator);
        WebElement element = getWebElement(locator);
        element.sendKeys(text);
        waitTextPresentInField(element, text);
    }

    protected void waitForVisibleElement(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitTextPresentInField(WebElement element, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public void scrollToElementByJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


}
