package magento.softwaretestingboard.com.tests;

import magento.softwaretestingboard.com.utils.BrowserManager;
import magento.softwaretestingboard.com.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBasic {
    protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        String url = PropertiesLoader.loadProperty("url");
        WebDriver driver = BrowserManager.doBrowserSetup();
        tdriver.set(driver);
        getDriver().get(url);

    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        tdriver.remove();

    }
}
