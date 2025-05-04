package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.ProductDetailPage;
import magento.softwaretestingboard.com.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Add to cart")
@Story("Add product to cart from Product Detail Page")
public class TestCase15 extends TestBasic {

    static String qty;
    static {
        try {
            qty = PropertiesLoader.loadProperty("quantity.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "Test Case 15: Verify that product is added to the cart")
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
            13. Verify that product is added to the cart""")

    public void AddProductToCart(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        TestCase14.verifyNameProductAfterAccessingFromSearchResultPage();
        verifyThatProductIsAdded();
    }

    @Step("Verify that product is added to the cart")
    public static void verifyThatProductIsAdded(){
        boolean successMessageIsDisplayed = new ProductDetailPage(getDriver())
                .addProductInCart(qty)
                .getAddToCartMessage()
                .isDisplayed();
        Assert.assertTrue(successMessageIsDisplayed,"Verify success message is displayed when product is added to the cart");
    }

}
