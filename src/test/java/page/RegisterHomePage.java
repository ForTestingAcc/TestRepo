package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterHomePage extends BasePage {
    private By userPanelButton = By.cssSelector("div.userPanel");
    private By doneButton = By.xpath("//button[text()=' Done ']");

    public RegisterHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDoneButton(){
        clickButton(doneButton);
    }

    public String getLoggedFirstName(){
        waitForElementPresent(userPanelButton);
        return getWebElement(userPanelButton).findElement(By.cssSelector("strong")).getText();
    }
}
