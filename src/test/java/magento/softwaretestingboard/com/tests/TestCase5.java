package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.LoggedHomePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Sign Out")
@Story("Sign out User")
public class TestCase5 extends TestBasic {

    @Test(description = "Test Case 5: Sign out User")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click on Sign In Link
            5. Verify 'Customer Login' is displayed
            6. Enter correct email and password
            7. Click on 'Sign In' button
            8. Verify that 'Logged in as FistName and LastName' is displayed
            9. Click on 'Sign out link'
            10. Verify that 'You are signed out' is displayed""")
    public void signOutUser() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase3.verifyCustomerLoginIsDisplayed();
        TestCase3.verifyLoggedInAsFirstNameLastNameIsDisplayed();
        verifyYouAreSignedOutIsDisplayed();
    }

    @Step("Verify that 'You are signed out' is displayed")
    private void verifyYouAreSignedOutIsDisplayed(){
        String verifyThatYouAreSignedOutText = new LoggedHomePage(getDriver())
                .navigateSignOutPage()
                .getYouAreSignOut()
                .getText().trim();
        Assert.assertEquals(verifyThatYouAreSignedOutText, "You are signed out","Verify that 'You are signed out' is displayed");
    }

}
