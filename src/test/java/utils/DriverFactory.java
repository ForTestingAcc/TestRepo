package utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private final static String PATH_TO_CHROMEDRIVER = "test/resources/chromedriver.exe";

    public static WebDriver getDriver() {
        WebDriver driver = null;

        String path = new File("src/test/resources/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", path);

        try {
            driver = new ChromeDriver();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions option = new ChromeOptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
