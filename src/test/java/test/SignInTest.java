package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.GuestHomePage;
import page.RegisterHomePage;
import page.RegistrationPage;
import page.WelcomePage;

public class SignInTest extends BaseTest {
    private String welcomePageURL = "https://staging.engineer.ai/home";
    private String emailForRegister = "TestEmailHyrhfs" + (int)(Math.random() * 5000 + 1) + "@gmail.com";
    private String firstName = "FirstName";
    private String lastName = "LastName";


    @BeforeTest
    public void openBaseURL() {
        goToURL(welcomePageURL, true);
        waitFor(500);
    }


    @AfterTest
    public void finishWork() {
        if (getDriver() != null)
            closeDriver();
    }

    @Test
    public void signInTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.clickTakeTourButton();
        welcomePage.clickSkipTourButton();

        GuestHomePage guestHomePage = new GuestHomePage(getDriver());
        waitFor(1000);
        guestHomePage.closeDiscountPopupIfNeed();
        guestHomePage.selectCurrency("US Dollars");
        guestHomePage.closeDiscountPopupIfNeed();
        guestHomePage.clickRegister();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.enterEmail(emailForRegister);
        registrationPage.clickNextButton();

        registrationPage.enterName(firstName + " " + lastName);
        registrationPage.selectPhoneCode("+380");
        registrationPage.enterPhoneNumber("972816635");
        registrationPage.enterPassword("Aq!6fhFhr*jF*9K");
        registrationPage.clickRegisterButton();

        RegisterHomePage registerHomePage = new RegisterHomePage(getDriver());
        registerHomePage.clickDoneButton();

        Assert.assertEquals(firstName, registerHomePage.getLoggedFirstName());
    }
}
