package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuestHomePage extends BasePage {

    private By closeDiscountPopupButton = By.cssSelector(".popHolder.intentPopup .closePopUp");
    private By closeSignInDiscountPopupButton = By.className(".discountTooltip.active .closeButton");
    private By selectCurrencyButton = By.cssSelector(".currencySelBox > span");
    private By currencyButtons = By.cssSelector(".userDropdownBox > .currencychoose");
    private By signInButton = By.xpath("//button[text()=' Sign In ']");
    private By registerButton = By.xpath("//div/strong[text()=' Register ']/..");

    public GuestHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickCloseDiscountPopupButton() {
        clickButton(closeDiscountPopupButton);
    }

    public void clickCloseSignInDiscountPopupButton() {
        clickButton(closeSignInDiscountPopupButton);
    }

    public void selectCurrency(String currency) {
        clickButton(selectCurrencyButton);
        waitFor(1000);
        clickButton(getWebElements(currencyButtons).stream().
                filter(WebElement -> WebElement.findElement(By.xpath(".//span")).
                        getText().equalsIgnoreCase(currency)).findFirst().orElse(null));
    }

    public void clickRegister() {
        moveToElement(signInButton, 1, 1);
        waitFor(200);
        clickButton(registerButton);
    }

    public void closeDiscountPopupIfNeed() {
        if(isElementPresent(closeDiscountPopupButton))
            clickCloseSignInDiscountPopupButton();
    }
}
