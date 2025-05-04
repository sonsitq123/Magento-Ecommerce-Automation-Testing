package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.CheckOutPage;
import magento.softwaretestingboard.com.pages.CreateAccountPage;
import magento.softwaretestingboard.com.pages.ShoppingCartPage;
import magento.softwaretestingboard.com.utils.JSONReader;
import magento.softwaretestingboard.com.utils.Util;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
@Story("Place Order")
public class TestCase18 extends TestBasic {

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
    static String password = "@Password" + Util.generateCurrentDateAndTime();
    static String passwordConfirmation = password;

    @Test(description = "Test Case 18: Place Order: Create Account: before Check Out")
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
            9. Verify 'Logged in as first name and last name' is displayed
            10. Enter product name in search input and click on search button
            11. Verify user is navigated to Search Result Page successfully
            12. Click on random product
            13. User is navigated to Product Detail Page successfully
            14. Verify name product after accessing from Search Result Page
            15. Click random 'Size'
            16. Click random 'Color'
            17. Enter value in  Quantity input
            18. Click 'Add to Cart' button
            19. Verify that product is added to the cart
            20. Click 'Cart" button
            21. Verify user is navigated to Shopping Cart Page
            22. Verify order information before checkout
            23. Click 'Proceed to Checkout'
            24. Verify user is navigated to Shipping Address in Checkout Page
            25. Enter personal information and choose a shipping method
            26. Click 'Next' button
            27. Verify New user is navigated to Review & Payment in Checkout Page
            28. Click 'My billing and shipping address are the same' checkbox
            29. Click 'Place Order'
            30. Verify that your first order has been successful""")

    public void registerBeforeCheckout() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase1.verifyCreateNewCustomerAccountIsDisplayed();
        verifyThankYouForRegistering();
        TestCase1.verifyLoggedInAsFirstNameAndLastNameIsDisplayed();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        TestCase14.verifyNameProductAfterAccessingFromSearchResultPage();
        TestCase15.verifyThatProductIsAdded();
        TestCase17.verifyUserIsNavigatedToShoppingCartPage();
        verifyUserIsNavigatedToShippingAddressInCheckoutPage();
        verifyNewUserIsNavigatedToReviewAndPaymentInCheckoutPage();
        verifyThatYourFirstOrderHasBeenSuccessful();
    }

    @Step("Verify that 'Thank you for registering with Main Website Store.' is displayed")
    public static void verifyThankYouForRegistering() {
        String thankYouForRegisteringWithMainWebsiteStoreText = new CreateAccountPage(getDriver())
                .fillCorrectSignUp(firstName, lastName, email, password, passwordConfirmation)
                .getThankYouForRegisteringWithMainWebsiteStore()
                .getText().trim();
        Assert.assertEquals(thankYouForRegisteringWithMainWebsiteStoreText,"Thank you for registering with Main Website Store.","Verify that 'Thank you for registering with Main Website Store.' is displayed");
    }

    @Step("Verify user is navigated to Shipping Address in Checkout Page")
    public static void verifyUserIsNavigatedToShippingAddressInCheckoutPage() {
        String shippingAddressText= new ShoppingCartPage(getDriver())
                .proceedToCheckoutButtonClick()
                .getShippingAddress()
                .getText().trim();
        Assert.assertEquals(shippingAddressText,"Shipping Address","Verify user is navigated to Shipping Address in Checkout Page");
    }

    @Step("Verify New user is navigated to Shipping Address in Checkout Page")
    private void verifyNewUserIsNavigatedToReviewAndPaymentInCheckoutPage() throws IOException, ParseException {
        String paymentMethodText = new CheckOutPage(getDriver())
                .fillShippingAddressWithNewUser()
                .getPaymentMethod()
                .getText().trim();
        Assert.assertEquals(paymentMethodText,"Payment Method","Verify user is navigated to Shipping Address in Checkout Page");
    }

    @Step("Verify that your first order has been successful")
    private void verifyThatYourFirstOrderHasBeenSuccessful() {
        String thankYouForYourPurchaseText = new CheckOutPage(getDriver())
                .paymentWithNewUser()
                .getThankYouForYourOrder()
                .getText().trim();
        Assert.assertEquals(thankYouForYourPurchaseText,"Thank you for your purchase!","Verify that your order has been successful");
    }

}
