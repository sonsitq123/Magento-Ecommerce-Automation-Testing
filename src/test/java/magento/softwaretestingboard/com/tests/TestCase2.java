package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.CreateAccountPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Creat Account")
@Story("Register User with existing email")
public class TestCase2 extends TestBasic{

    @Test(description = "Test Case 2: Register User with existing email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
           1. Launch browser
           2. Navigate to url 'https://magento.softwaretestingboard.com'
           3. Verify that Home Page is visible successfully
           4. Click on 'Create Account' button
           6. Enter first name, last name, password and already registered with email address
           7. Click on 'Create Account' button
           8. Verify error 'There is already an account with this email address.'""")
    public void registerUserWithExistingEmail() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase1.verifyCreateNewCustomerAccountIsDisplayed();
        verifyEmailAlreadyExistsErrorMessageTextIsDisplayed();
    }

    @Step("Verify error 'There is already an account with this email address.'")
    private void verifyEmailAlreadyExistsErrorMessageTextIsDisplayed() throws IOException, ParseException {
        String emailAlreadyExistsErrorMessageText = new CreateAccountPage(getDriver())
                .fillInCorrectSignUp()
                .getEmailAlreadyExistsErrorMessage()
                .getText();
        Assert.assertEquals(emailAlreadyExistsErrorMessageText, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.","Verify error 'There is already an account with this email address.'" );
    }

}
