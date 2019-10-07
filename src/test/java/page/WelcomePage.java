package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {
    private By takeTourButton = By.xpath("//button[text()='TAKE A TOUR ']");
    private By skipTourButton = By.xpath("//button[text()='Skip Tour ']");
    private By overlayMarkNewElement = By.cssSelector("div.overlaymarknew");

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void clickTakeTourButton() {
        clickButton(takeTourButton);
    }

    public void clickSkipTourButton() {
        waitForElementPresent(overlayMarkNewElement);
        waitForVisibleElement(overlayMarkNewElement);
        clickButton(skipTourButton);
    }
}
