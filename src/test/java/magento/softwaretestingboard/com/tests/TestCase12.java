package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import magento.softwaretestingboard.com.pages.SearchResultPage;
import magento.softwaretestingboard.com.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Product Search")
@Story("Search for a product by Name")
public class TestCase12 extends TestBasic{

    static String search;
    static {
        try {
            search = PropertiesLoader.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "Test Case 12: Search Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Enter product name in search input and click on search button
            6. Verify user is navigated to Search Result Page successfully
            5. Verify all product related to search are displayed""")

    public void searchProduct(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigateToSearchResultPage();
        verifyAllProductRelatedToSearchAreDisplayed();
    }

    @Step("Verify User is navigated to Search Result Page successfully")
    public static void verifyUserIsNavigateToSearchResultPage(){
        String searchResultForTexT = new HomePage(getDriver())
                .fillSearchProductInput(search)
                .getSearchResultFor()
                .getText().trim();
        Assert.assertEquals(searchResultForTexT,"Search results for: " + "'" + search + "'","Verify User is navigated to Search Result Page successfully");
    }

    @Step("Verify all product related to search are displayed")
    private List<String> verifyAllProductRelatedToSearchAreDisplayed(){
        List<String> productsNames = new SearchResultPage(getDriver()).getProductsSearchName();

        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
        }
        return productsNames;
    }
}
