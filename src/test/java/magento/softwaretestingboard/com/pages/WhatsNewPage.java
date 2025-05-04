package magento.softwaretestingboard.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhatsNewPage {
    @FindBy(css = ".base")
    private WebElement whatsNew;

    private WebDriver driver;

    public WhatsNewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getWhatsNew() {
        return whatsNew;
    }

}
