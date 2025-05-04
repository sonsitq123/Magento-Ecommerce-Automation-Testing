package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.JSONReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CreateAccountPage {
    @FindBy(css = ".base")
    public WebElement createNewCustomerAccount;

    @FindBy(id = "firstname")
    public WebElement firstNameInput;

    @FindBy(id = "lastname")
    public WebElement lastNameInput;

    @FindBy(id = "email_address")
    public WebElement emailAddressInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    public WebElement passwordConfirmationInput;

    @FindBy(css = "button[title='Create an Account']")
    public WebElement submitButton;

    @FindBy(css = ".message-error.error.message")
    public WebElement emailAlreadyExistsErrorMessage;

    @FindBy(xpath = "//a[normalize-space()='click here']")
    public WebElement getToForgotPasswordLink;

    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getCreateNewCustomerAccount() {
        return createNewCustomerAccount;
    }

    public void fillSignUp(String firstName, String lastName, String email, String password,String passwordConfirmation) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailAddressInput.sendKeys(email);
        passwordInput.sendKeys(password);
        passwordConfirmationInput.sendKeys(passwordConfirmation);
        submitButton.click();
    }

    public MyAccountPage fillCorrectSignUp(String firstName, String lastname,String email, String password, String passwordConfirmation) {
        fillSignUp(firstName, lastname, email, password, passwordConfirmation);
        return new MyAccountPage(driver);
    }

    public CreateAccountPage fillInCorrectSignUp() throws IOException, ParseException {
        fillSignUp(JSONReader.existingAccount("firstname"),
                JSONReader.existingAccount("lastname"),
                JSONReader.existingAccount("email"),
                JSONReader.existingAccount("password"),
                JSONReader.existingAccount("passwordConfirmation"));
        return this;
    }

    public WebElement getEmailAlreadyExistsErrorMessage(){
        return emailAlreadyExistsErrorMessage;
    }

}
