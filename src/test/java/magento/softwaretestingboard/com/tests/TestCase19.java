package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.CheckOutPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
@Story("Place Order")
public class TestCase19 extends TestBasic {

    @Test(description = "Test Case 19: Place Order: Sign In before Check Out")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click 'Sign In'
            5. Verify 'Customer Login' is displayed
            6. Enter correct email and password
            7. Click on 'Sign In' button
            8. Verify that 'Logged in as FistName and LastName' is displayed
            9. Enter product name in search input and click on search button
            10. Verify user is navigated to Search Result Page successfully
            11. Click on random product
            12. User is navigated to Product Detail Page successfully
            13. Verify name product after accessing from Search Result Page
            14. Click random 'Size'
            15. Click random 'Color'
            16. Enter value in  Quantity input
            17. Click 'Add to Cart' button
            18. Verify that product is added to the cart
            19. Click 'Cart" button
            20. Verify user is navigated to Shopping Cart Page
            21. Verify order information before checkout
            22. Click 'Proceed to Checkout'
            23. Verify user is navigated to Shipping Address in Checkout Page
            24. Enter personal information and choose a shipping method
            25. Click 'Next' button
            26. Verify user is navigated to Review & Payment in Checkout Page
            27. Click 'My billing and shipping address are the same' checkbox
            28. Click 'Place Order'
            29. Verify that your order has been successful""")

    public void signInBeforeCheckOut() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase3.verifyCustomerLoginIsDisplayed();
        TestCase3.verifyLoggedInAsFirstNameLastNameIsDisplayed();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        TestCase14.verifyNameProductAfterAccessingFromSearchResultPage();
        TestCase15.verifyThatProductIsAdded();
        TestCase17.verifyUserIsNavigatedToShoppingCartPage();
        TestCase18.verifyUserIsNavigatedToShippingAddressInCheckoutPage();
        verifyUserIsNavigatedToReviewAndPaymentInCheckoutPage();
        verifyThatYourOrderHasBeenSuccessful();
    }

    @Step("Verify user is navigated to Review & Payment in Checkout Page")
    public void verifyUserIsNavigatedToReviewAndPaymentInCheckoutPage(){
        String paymentMethodText = new CheckOutPage(getDriver())
                .shippingAddressWithExistingAccount()
                .getPaymentMethod()
                .getText().trim();
        Assert.assertEquals(paymentMethodText,"Payment Method","Verify user is navigated to Review & Payment in Checkout Page");
    }

    @Step("Verify that your order has been successful")
    public void verifyThatYourOrderHasBeenSuccessful(){
        String thankYouForYourPurchaseText = new CheckOutPage(getDriver())
                .paymentWithExistingAccount()
                .getThankYouForYourOrder()
                .getText().trim();
        Assert.assertEquals(thankYouForYourPurchaseText,"Thank you for your purchase!","Verify that your order has been successful");
    }

}
