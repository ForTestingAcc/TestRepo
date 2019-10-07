package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import utils.DriverFactory;

public class BaseTest {
    private WebDriver driver;

    public BaseTest(){
        driver = DriverFactory.getDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    void goToURL(String url, boolean maximizeWindow) {
        driver.get(url);
        if (maximizeWindow) {
            driver.manage().window().maximize();
        }
    }

    void waitFor(long mills){
        try{
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    void closeDriver(){
        if(driver != null)
            driver.close();
    }
}
