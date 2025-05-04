package magento.softwaretestingboard.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy(css = ".base")
    private WebElement customerLogin;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(css = "div[role='alert']")
    private WebElement signInErrorMessage;

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCustomerLogin() {
        return customerLogin;
    }

    public void fillSignIn(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public LoggedHomePage fillCorrectLogin(String email, String password) {
        fillSignIn(email, password);
        return new LoggedHomePage(driver);
    }

    public SignInPage fillInCorrectLogin(String email, String password) {
        fillSignIn(email, password);
        return this;
    }

    public WebElement getSignInErrorMessage () {
        return signInErrorMessage;
    }

}
