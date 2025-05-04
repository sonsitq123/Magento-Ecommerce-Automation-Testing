package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.ProductDetailPage;
import magento.softwaretestingboard.com.pages.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Product Details")
@Story("Verify product name from Search Result Page")
public class TestCase14 extends TestBasic{

    @Test(description = "Test Case 14: Verify name product after accessing from Search Result Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Enter product name in search input and click on search button
            5. Verify user is navigated to Search Result Page successfully
            6. Click random product
            7. User is navigated to Product Detail Page successfully
            8. Verify name product after accessing from Search Result Page""")

    public void VerifyProductDetailPageFromSearchResultPage(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase12.verifyUserIsNavigateToSearchResultPage();
        verifyNameProductAfterAccessingFromSearchResultPage();
    }

    @Step("Verify name product after accessing from Search Result Page")
    public static void verifyNameProductAfterAccessingFromSearchResultPage(){
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());

        WebElement productElement = searchResultPage.getRandomSearchProductElement();
        String expectedProductName = searchResultPage.getSearchProductNameFormElement(productElement);

        ProductDetailPage detailPage = searchResultPage.clickSearchProductImage(productElement);
        String actualProductName = detailPage.getDetailProductName().getText().trim();

        Assert.assertEquals(actualProductName, expectedProductName,"Verify product name is displayed correctly on Product Detail Page");
    }

}

