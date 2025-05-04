package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Menu navigation")
@Story("Display Women menu and Bottoms section")
public class TestCase8 extends TestBasic {

    @Test(description = "Test Case 8: Verify Women Menu and Bottoms section is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Verify 'Women' menu is Displayed
            5. Hover to 'Women' menu
            6. Hover to 'Women/Bottoms'
            7. Verify Bottoms sections is displayed""")
    public void VerifyWomenMenuAndBottomSectionIsDisplayed(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase7.verifyWomenMenuIsDisplayed();
        verifyBottomSectionIsDisplayed();
    }

    @Step("Verify 'Bottoms sections' is displayed")
    public void verifyBottomSectionIsDisplayed(){
        HomePage homePage = new HomePage(getDriver());
        homePage.hoverWomenBottoms();
        Assert.assertTrue(homePage.isWomenPantsDisplayed()," 'Women/Bottoms/Pants' is displayed");
        Assert.assertTrue(homePage.isWomenShortsDisplayed(),"'Women/Bottoms/Shorts' is displayed");
    }

}
