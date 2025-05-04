package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import magento.softwaretestingboard.com.pages.ProductDetailPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Product Details")
@Story("Verify product name from Home Page")
public class TestCase13 extends TestBasic{

    @Test(description = "Test Case 13: Verify name product after accessing from Home Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch browser
            2. Navigate to url 'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Click  random product
            5. Verify user is navigated to Search Result Page successfully
            6. Click random product
            7. User is navigated to Product Detail Page successfully
            8. Verify name product after accessing from Home Page""")

    public void VerifyNameProductHomePage(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyNameProductAfterAccessingFromHomePage();
    }

    @Step("Verify name product after accessing from Home Page")
    public static void verifyNameProductAfterAccessingFromHomePage(){
        HomePage homePage = new HomePage(getDriver());

        WebElement productElement = homePage.getRandomHomeProductElement();
        String expectedProductName = homePage.getHomeProductNameFormElement(productElement);

        ProductDetailPage detailPage = homePage.clickHomeProductImage(productElement);
        String actualProductName = detailPage.getDetailProductName().getText().trim();

        Assert.assertEquals(actualProductName, expectedProductName,"Verify product name is displayed correctly on Product Detail Page");
    }

}
