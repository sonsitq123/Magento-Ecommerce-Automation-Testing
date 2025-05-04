package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.ProductDetailPage;
import magento.softwaretestingboard.com.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Regression Tests")
@Feature("Verify")
@Story("Shopping Cart Page")
public class TestCase17 extends TestBasic{

    @Test(description = "Test Case 17: Verify order information before Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Enter product name in search input and click on search button
            5. Verify user is navigated to Search Result Page successfully
            6. Click on random product
            7. User is navigated to Product Detail Page successfully
            8. Verify name product after accessing from Search Result Page
            9. Click random 'Size'
            10. Click random 'Color'
            11. Enter value in  Quantity input
            12. Click 'Add to Cart' button
            13. Verify that product is added to the cart
            14. Click 'Cart" button
            15. Verify user is navigated to Shopping Cart Page
            16. Verify order information before checkout""")

    public void verifyOrderInformationBeforeCheckoutTest(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        TestCase14.verifyNameProductAfterAccessingFromSearchResultPage();
        TestCase15.verifyThatProductIsAdded();
        verifyUserIsNavigatedToShoppingCartPage();
        verifyOrderInformationBeforeCheckout();
    }

    @Step("Verify user is navigated to Shopping Cart Page")
    public static void verifyUserIsNavigatedToShoppingCartPage(){
        String shoppingCartPageText = new ProductDetailPage(getDriver())
                .viewAndEditCartButtonClick()
                .getShoppingCart()
                .getText();
        Assert.assertEquals(shoppingCartPageText,"Shopping Cart","Verify user is navigated to Shopping Cart Page");
    }

    @Step("Verify order information before checkout")
    private void verifyOrderInformationBeforeCheckout(){
        List<String> productNames = new ShoppingCartPage(getDriver()).getNameProducts();
        List<String> prices = new ShoppingCartPage(getDriver()).getProductsPrices();
        List<String> quantities = new ShoppingCartPage(getDriver()).getProductsQty();
        List<String> subtotals = new ShoppingCartPage(getDriver()).getProductsSubtotal();

        String priceStr = prices.get(0).replace("$", "").replace(",", "").trim();
        String qtyStr = quantities.get(0).trim();
        String subtotalStr = subtotals.get(0).replace("$", "").replace(",", "").trim();

        double price = Double.parseDouble(priceStr);
        int quantity = Integer.parseInt(qtyStr);
        double subtotal = Double.parseDouble(subtotalStr);
        double expectedSubtotal = price * quantity;

        System.out.printf("Product: %s | Price: %.2f | Qty: %d | Subtotal: %.2f%n", productNames.get(0), price, quantity, subtotal);

        Assert.assertEquals(subtotal, expectedSubtotal, 0.01, "Subtotal should match price * quantity");
    }

}
