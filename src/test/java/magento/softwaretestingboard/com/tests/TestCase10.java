package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Menu navigation")
@Story("Display Men menu and Bottoms section")
public class TestCase10 extends TestBasic{

    @Test(description = "Test Case 10: Verify Men menu and Bottoms section is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Verify 'Men' menu is Displayed
            5. Hover to 'Men' menu
            6. Hover to 'Men/Bottoms'
            7. Verify 'Bottoms section' is displayed""")

    public void verifyMenMenuAndTopSectionIsDisplayed(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase9.verifyMenMenuIsDisplayed();
        verifyMenBottomSectionIsDisplayed();
    }

    @Step("Verify 'Bottoms sections' is displayed")
    public void verifyMenBottomSectionIsDisplayed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.hoverMenBottoms();
        Assert.assertTrue(homePage.isMenPantsDisplayed(),"'Men/Bottoms/Pants' is displayed");
        Assert.assertTrue(homePage.isMenShortsDisplayed(),"'Men/Bottoms/Shorts' is displayed");
    }

}