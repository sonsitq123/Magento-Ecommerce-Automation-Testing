package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage {
    @FindBy(css = "div[class='panel header'] span[class='logged-in']")
    private WebElement welcomeFirstNameLastName;

    @FindBy(css = "div[class='panel header'] button[type='button']")
    private WebElement dropDownButton;

    @FindBy(css = "div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)")
    private WebElement myAccountLink;

    @FindBy(css = "div[aria-hidden='false'] li[class='link wishlist'] a")
    private WebElement wishListLink;

    @FindBy(css = "div[aria-hidden='false'] li[data-label='or'] a")
    private WebElement signOutLink;

    private WebDriver driver;

    public LoggedHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getWelcomeFirstNameLastName() {
        SeleniumHelper.waitForElementToBeVisible(driver, welcomeFirstNameLastName);
        return welcomeFirstNameLastName;
    }

    public SignOutPage navigateSignOutPage(){
        dropDownButton.click();
        signOutLink.click();
        return new SignOutPage(driver);
    }

}
