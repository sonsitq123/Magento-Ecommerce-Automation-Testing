package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Cart")
@Story("Remove Product From Cart")
public class TestCase16 extends TestBasic {

    @Test(description = "Test Case 16: Verify product is removed from the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4.Click on random product
            5. Verify user is navigated to Search Result Page successfully
            6. Click random product
            7. User is navigated to Product Detail Page successfully
            8. Verify name product after accessing from Search Result Page
            9. Click random 'Size'
            10. Click random 'Color'
            11. Enter value in Quantity input
            12. Click 'Add to Cart' button
            13. Verify success message is displayed when product is added to the cart
            14. Click 'Cart Button'
            15. Click 'Remove Product button'
            16. Verify product is removed from the cart""")
    public void RemoveProductFromCart(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        TestCase14.verifyNameProductAfterAccessingFromSearchResultPage();
        TestCase15.verifyThatProductIsAdded();
        verifyThatProductIsRemovedFromTheCart();
    }

    @Step("Verify product is removed from the cart")
    public static void verifyThatProductIsRemovedFromTheCart(){
        String notProductInCartMessage = new ProductDetailPage(getDriver())
                .removeProductFromCart()
                .getNotProductInCartMessage()
                .getText().trim();
        Assert.assertEquals(notProductInCartMessage,"You have no items in your shopping cart.","Verify product is removed from the cart");
    }

}
