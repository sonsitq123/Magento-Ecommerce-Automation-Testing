package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouForYourOrderPage {
    @FindBy(xpath = "//span[@class='base']")
    private WebElement thankYouForYourOrder;

    private WebDriver driver;

    public ThankYouForYourOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getThankYouForYourOrder() {
        SeleniumHelper.waitForElementToBeVisible(driver, thankYouForYourOrder);
        return thankYouForYourOrder;
    }

}
