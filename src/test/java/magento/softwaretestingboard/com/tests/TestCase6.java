package magento.softwaretestingboard.com.tests;

import io.qameta.allure.*;
import magento.softwaretestingboard.com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Page Navigation")
@Story("Verify What's New Page")
public class TestCase6 extends TestBasic{

    @Test(description = "Test Case 6: Verify What's New Page")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("""
            1. Launch Browser
            2. Navigate to url'https://magento.softwaretestingboard.com'
            3. Verify that Home Page is visible successfully
            4. CLick on 'What's New Link'
            5. Verify user is navigated to What's New Page successfully""")
    public void VerifyWhatsNewPage(){
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToWhatsNewPage();
    }

    @Step("Verify user is navigate to What's New Page successfully")
    private void verifyUserIsNavigatedToWhatsNewPage(){
        String whatsNewText = new HomePage(getDriver())
                .whatsNewPageClick()
                .getWhatsNew()
                .getText().trim();
        Assert.assertEquals(whatsNewText, "What's New","Verify user is navigate to What's New Page successfully");
    }

}

