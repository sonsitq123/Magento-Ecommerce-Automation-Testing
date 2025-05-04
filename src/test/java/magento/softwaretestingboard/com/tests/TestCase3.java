package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import magento.softwaretestingboard.com.pages.SignInPage;
import magento.softwaretestingboard.com.utils.JSONReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Sign In")
@Story("Sign In with correct email and password")
public class TestCase3 extends TestBasic{

    @Test(description = "Test Case 3: Sign in User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click 'Sign In' Link
            5. Verify 'Customer Login' is displayed
            6. Enter correct email and password
            7. Click on 'Sign In' button
            8. Verify that 'Logged in as FistName and LastName' is displayed""")

    public void SignInUserWithCorrectEmailAndPassword() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyCustomerLoginIsDisplayed();
        verifyLoggedInAsFirstNameLastNameIsDisplayed();
    }

    @Step("Verify 'Customer Login' is visible")
    public static void verifyCustomerLoginIsDisplayed() {
        String verifyCustomerLogInIsVisibleText = new HomePage(getDriver())
                .signInClick()
                .getCustomerLogin()
                .getText();
        Assert.assertEquals(verifyCustomerLogInIsVisibleText, "Customer Login", "Verify 'Customer Login' is displayed");
    }

    @Step("Verify that 'Logged in as FirstName and LastName' is visible")
    public static void verifyLoggedInAsFirstNameLastNameIsDisplayed() throws IOException, ParseException {
        String welcomeFirstNameAndLastNameText = new SignInPage(getDriver())
                .fillCorrectLogin(JSONReader.existingAccount("email"), JSONReader.existingAccount("password"))
                .getWelcomeFirstNameLastName()
                .getText();
        Assert.assertEquals(welcomeFirstNameAndLastNameText,JSONReader.existingAccount("welcomeFirstNameAndLastName"),"Verify that 'Logged in as FirstName and LastName' is displayed");
    }

}
