package magento.softwaretestingboard.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(css = ".message-success.success.message")
    private WebElement thankYouForRegisteringWithMainWebsiteStore;

    @FindBy(css = "a[aria-label='store logo']")
    private WebElement storeLogoButton;

    @FindBy(css = ".base")
    private WebElement myAccount;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getThankYouForRegisteringWithMainWebsiteStore() {
        return thankYouForRegisteringWithMainWebsiteStore;
    }

    public LoggedHomePage loggedHomePageClick() {
        storeLogoButton.click();
        return new LoggedHomePage(driver);
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

}
