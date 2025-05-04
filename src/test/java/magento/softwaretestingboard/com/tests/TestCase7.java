package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Menu navigation")
@Story("Display Women menu and Tops section")
public class TestCase7 extends TestBasic{

    @Test(description = "Test Case 7: Verify Women menu and Tops section is displayed")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. Verify 'Women' menu is Displayed
            5. Hover to 'Women' menu
            6. Hover to 'Women/Tops'
            7. Verify 'Tops section' is displayed""")
    public void verifyWomenMenuAndTopSectionIsDisplayed() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyWomenMenuIsDisplayed();
        verifyWomenTopSectionIsDisplayed();
    }
    @Step("Verify 'Women' menu is Displayed")
    public static void verifyWomenMenuIsDisplayed() {
        boolean womenMenuIsDisplayed = new HomePage(getDriver())
                .getWomenMenu()
                .isDisplayed();
        Assert.assertTrue(womenMenuIsDisplayed," 'Women' menu is displayed");
    }

    @Step("Verify 'Tops sections' is displayed")
    public void verifyWomenTopSectionIsDisplayed() {
        HomePage homePage = new HomePage(getDriver());
        homePage.hoverWomenTop();
        Assert.assertTrue(homePage.isWomenJacketsDisplayed()," 'Women/Tops/Jackets' is displayed");
        Assert.assertTrue(homePage.isWomenHoodiesAndSweatShirtsDisplayed(),"'Women/Tops/HoodiesAndSweatShirts' is displayed");
        Assert.assertTrue(homePage.isWomenTeesDisplayed(),"'Women/Tops/Tees' is displayed");
        Assert.assertTrue(homePage.isWomenBrasDisplayed(),"'Women/Tops/BrasAndTanks' is displayed");
    }

}
