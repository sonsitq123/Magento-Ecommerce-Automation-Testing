package magento.softwaretestingboard.com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserManager {
    public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String browserName = PropertiesLoader.loadProperty("browser.name");

        if (browserName.equals("Chrome")) {

            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browserName.equals("Firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        return driver;

    }
}