package magento.softwaretestingboard.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {
    @FindBy(css = ".base")
    private WebElement youAreSignOut;

    private WebDriver driver;

    public SignOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getYouAreSignOut() {
        return youAreSignOut;
    }

}
