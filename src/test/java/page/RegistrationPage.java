package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    private By emailField = By.cssSelector("input[name='signup_email']");
    private By nameField = By.cssSelector("input[name='firstlastname']");
    private By nextButton = By.cssSelector(".signUpNextButtonClass");
    private By selectPhoneCodeButton = By.cssSelector(".dropbtn.btn");
    private By phoneCodeElements = By.xpath("//span[@class='dial-code']");
    private By phoneNumberField = By.cssSelector("input[placeholder='Mobile Number']");
    private By passwordField = By.cssSelector("input[placeholder='Password']");
    private By registerButton = By.xpath("//button[@class='submitButton' and text()=' Register ']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        writeTextToField(emailField, email);
    }

    public void clickNextButton() {
        clickButton(nextButton);
    }

    public void enterName(String firstName) {
        writeTextToField(nameField, firstName);
    }

    public void selectPhoneCode(String codeNumber) {
        clickButton(selectPhoneCodeButton);
        waitFor(1000);
        WebElement codeElement = getWebElements(phoneCodeElements).
                stream().filter(WebElement -> WebElement.getText().replace(" ", "").
                equalsIgnoreCase(codeNumber)).findFirst().orElse(null);

        codeElement = codeElement.findElement(By.xpath("./../.."));

        scrollToElementByJs(codeElement);
        waitFor(1000);
        clickButton(codeElement);
    }

    public void enterPhoneNumber(String phoneNumber) {
        writeTextToField(phoneNumberField, phoneNumber);
    }

    public void enterPassword(String password) {
        writeTextToField(passwordField, password);
    }

    public void clickRegisterButton() {
        clickButton(registerButton);
    }
}
