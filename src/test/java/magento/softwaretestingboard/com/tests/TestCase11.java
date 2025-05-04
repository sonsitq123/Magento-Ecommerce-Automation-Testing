package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Menu navigation")
@Story("Display Gear menu and gear section")
public class TestCase11 extends TestBasic{

    @Test(description = "Test Case 11: Verify Gear menu and gear section is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Verify 'Gear' menu is Displayed
            5. Hover to 'Gear' menu
            6. Verify 'Gear section' is displayed""")

    public void VerifyGearMenuAndGearSectionIsDisplayed() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyGearMenuIsDisplayed();
        verifyGearSectionIsDisplayed();
    }

    @Step("Verify 'Gear' menu is displayed")
    public void verifyGearMenuIsDisplayed(){
        boolean gearMenuIsDisplayed = new HomePage(getDriver())
                .getGearMenu()
                .isDisplayed();
        Assert.assertTrue(gearMenuIsDisplayed,"'Gear Menu' is displayed");
    }
    @Step("Verify 'Gear section' is displayed")
    public void verifyGearSectionIsDisplayed(){
        HomePage homePage = new HomePage(getDriver());
        homePage.hoverGearMenu();
        Assert.assertTrue(homePage.isBagsDisplayed(),"'Gear/Bags' is displayed");
        Assert.assertTrue(homePage.isFitnessEquipmentDisplayed(),"'Gear/FitnessEquipment' is displayed");
        Assert.assertTrue(homePage.isWatchesDisplayed(),"'Gear/Watches' is displayed");
    }

}
