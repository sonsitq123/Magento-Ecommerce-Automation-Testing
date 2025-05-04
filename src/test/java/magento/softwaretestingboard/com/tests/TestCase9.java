package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Menu navigation")
@Story("Display Men menu and Tops section")
public class TestCase9 extends TestBasic {

    @Test(description = "Test Case 9: Verify Men menu and Tops section is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Verify 'Men' menu is Displayed
            5. Hover to 'Men' menu
            6. Hover to 'Men/Tops'
            7. Verify 'Tops section' is displayed""")

    public void verifyMenMenuAndTopSectionIsDisplayed(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyMenMenuIsDisplayed();
        verifyMenTopSectionIsDisplayed();
    }

    @Step("Verify 'Men' menu is Displayed")
    public static void verifyMenMenuIsDisplayed(){
        boolean menMenuIsDisplayed = new HomePage(getDriver())
                .getMenMenu()
                .isDisplayed();
        Assert.assertTrue(menMenuIsDisplayed, "Men menu is displayed");
    }

    @Step("Verify 'Tops sections' is displayed")
    public void verifyMenTopSectionIsDisplayed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.hoverMenTop();
        Assert.assertTrue(homePage.isMenJacketsDisplayed(),"'Men/Tops/Jackets' is displayed");
        Assert.assertTrue(homePage.isMenHoodiesAndSweatShirtsDisplayed(),"'Men/Tops/HoodiesAndShirts' is displayed");
        Assert.assertTrue(homePage.isMenTeesDisplayed(),"'Men/Tops/Tees' is displayed");
        Assert.assertTrue(homePage.isMenTanksDisplayed(),"'Men/Tops/Tanks' is displayed");
    }

}

