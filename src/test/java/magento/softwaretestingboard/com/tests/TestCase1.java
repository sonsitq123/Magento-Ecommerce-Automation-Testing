package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.CreateAccountPage;
import magento.softwaretestingboard.com.pages.HomePage;
import magento.softwaretestingboard.com.pages.MyAccountPage;
import magento.softwaretestingboard.com.utils.JSONReader;
import magento.softwaretestingboard.com.utils.Util;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Create Account")
@Story("Register User")
public class TestCase1 extends TestBasic{

    static String firstName;
    static String lastName;
    static {
        try {
            firstName = JSONReader.existingAccount("firstname");
            lastName = JSONReader.existingAccount("lastname");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String email = "email" + Util.generateCurrentDateAndTime() + "@gmail.com";
    static String password = "Password@" + Util.generateCurrentDateAndTime();
    static String passwordConfirmation = password;

    public TestCase1() throws IOException, ParseException {
    }

    @Test(description = "Test Case 1: Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click on 'Create Account' button
            5. Enter first name, last name, email, password, password confirmation
            6. Click on Submit button
            7. Verify 'Thank you for Registering with main Website Store' is displayed
            8. Click on Store Logo button
            9. Verify 'Logged in as first name and last name' is displayed""")

    public void registerUser() throws IOException, ParseException {
        verifyThatHomePageIsVisibleSuccessfully();
        verifyCreateNewCustomerAccountIsDisplayed();
        verifyThankYouForRegisteringWithMainWebsiteStoreIsDisplayed();
        verifyLoggedInAsFirstNameAndLastNameIsDisplayed();
    }

    @Step("Verify that home page is visible successfully")
    public static void verifyThatHomePageIsVisibleSuccessfully() {
        boolean homePageVisible = new HomePage(getDriver())
                .getHomePage()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "Verify that home page is displayed");
    }

    @Step("Verify 'Create New Customer Account' is visible")
    public static void verifyCreateNewCustomerAccountIsDisplayed() {
        String createNewCustomerAccountText= new HomePage(getDriver())
                .createAccountClick()
                .getCreateNewCustomerAccount()
                .getText().trim();
        Assert.assertEquals(createNewCustomerAccountText, "Create New Customer Account", "Verify that create new customer account is displayed");
    }

    @Step("Verify that 'Thank you for registering with Main Website Store.' is displayed")
    public  static void verifyThankYouForRegisteringWithMainWebsiteStoreIsDisplayed() throws IOException, ParseException {
        String thankYouForRegisteringWithMainWebsiteStoreText = new CreateAccountPage(getDriver())
                .fillCorrectSignUp(firstName, lastName, email, password, passwordConfirmation)
                .getThankYouForRegisteringWithMainWebsiteStore()
                .getText().trim();
        Assert.assertEquals(thankYouForRegisteringWithMainWebsiteStoreText,"Thank you for registering with Main Website Store.","Verify that 'Thank you for registering with Main Website Store.' is displayed");
    }

    @Step("Verify that 'Logged in as FirstName and LastName' is displayed")
    public static void verifyLoggedInAsFirstNameAndLastNameIsDisplayed() {
        String welcomeFirstNameAndLastNameText = new MyAccountPage(getDriver())
                .loggedHomePageClick()
                .getWelcomeFirstNameLastName()
                .getText().trim();
        Assert.assertEquals(welcomeFirstNameAndLastNameText,"Welcome, " + firstName + " " + lastName + "!","Verify that 'Logged in as username' is displayed");
    }
}
