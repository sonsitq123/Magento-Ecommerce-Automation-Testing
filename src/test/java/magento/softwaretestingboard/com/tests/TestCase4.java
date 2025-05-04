package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.SignInPage;
import magento.softwaretestingboard.com.utils.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Sign In")
@Story("Sign In User with incorrect email and password")
public class TestCase4 extends TestBasic{

    String email = "email" + Util.generateCurrentDateAndTime() + "@gmail.com";
    String password = "@Password" + Util.generateCurrentDateAndTime() ;

    @Test(description = "Test Case 4: Sign In User with incorrect emil with password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click on Sign In Link
            5. Verify 'Customer Login' is displayed
            6. Enter correct email and password
            7. Click on 'Sign In' button
            8. Verify error 'The account sign in was in correct' is displayed""")
    public void sigInUserWithIncorrectEmailAndPassword(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase3.verifyCustomerLoginIsDisplayed();
        verifyErrorTheAccountSignInWasInCorrect();
    }
    @Step("Verify Error 'The account sign in was in correct' is displayed")
    public void verifyErrorTheAccountSignInWasInCorrect(){
        String TheAccountSignInWasInIncorrectText = new SignInPage(getDriver())
                .fillInCorrectLogin(email, password)
                .getSignInErrorMessage()
                .getText().trim();
        Assert.assertEquals(TheAccountSignInWasInIncorrectText, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", "Verify Error 'The account sign in was in correct' is displayed");
    }

}
