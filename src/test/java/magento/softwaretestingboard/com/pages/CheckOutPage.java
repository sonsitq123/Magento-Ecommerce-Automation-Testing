package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.JSONReader;
import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class CheckOutPage {
    //shipping
    @FindBy(css = "li[id='shipping'] div[class='step-title']")
    private WebElement shippingAddress;

    @FindBy(css = "input[name='company']")
    private WebElement companyInput;

    @FindBy(css = "input[name='street[0]']")
    private WebElement streetAddressInput1;

    @FindBy(css = "input[name='street[1]']")
    private WebElement streetAddressInput2;

    @FindBy(css = "input[name='street[2]']")
    private WebElement streetAddressInput3;

    @FindBy(css = "input[name='city']")
    private WebElement cityInput;

    @FindBy(css = "select[name='region_id']")
    private WebElement stateProvinceSelect;

    @FindBy(css = "input[name='postcode']")
    private WebElement zipPostalCodeInput;

    @FindBy(name = "country_id")
    private WebElement countrySelect;

    @FindBy(css = "input[name='telephone']")
    private WebElement phoneNumberInput;

    @FindBy(css = "input[value='flatrate_flatrate']")
    private WebElement flatRateCheckBox;

    @FindBy(css = "input[value='tablerate_bestway']")
    private WebElement bestWayCheckBox;

    @FindBy(css = ".button.action.continue.primary")
    private WebElement nextButton;

    @FindBy(css = ".shipping-address-item.selected-item")
    private WebElement defaultAddress;

    //review&Payments
    @FindBy(css = "div[class='payment-group'] div[class='step-title']")
    private WebElement paymentMethod;

    @FindBy(css = "button[title='Place Order']")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getShippingAddress() {
        SeleniumHelper.waitForElementToBeVisible(driver, shippingAddress);
        return shippingAddress;
    }

    public CheckOutPage fillShippingAddressWithNewUser() throws IOException, ParseException {
        SeleniumHelper.waitForElementToBeVisible(driver, companyInput);
        companyInput.sendKeys(JSONReader.personalInformation("company"));
        SeleniumHelper.waitForElementToBeVisible(driver, streetAddressInput1);
        streetAddressInput1.sendKeys(JSONReader.personalInformation("streetAddress1"));
        streetAddressInput2.sendKeys(JSONReader.personalInformation("streetAddress2"));
        streetAddressInput3.sendKeys(JSONReader.personalInformation("streetAddress3"));
        cityInput.sendKeys(JSONReader.personalInformation("city"));
        Select stateProvince = new Select(stateProvinceSelect);
        stateProvince.selectByValue(JSONReader.personalInformation("stateProvince"));
        zipPostalCodeInput.sendKeys(JSONReader.personalInformation("zipPostalCode"));
        Select country = new Select(countrySelect);
        country.selectByValue(JSONReader.personalInformation("country"));
        phoneNumberInput.sendKeys(JSONReader.personalInformation("phoneNumber"));
        //flatRateCheckBox.click();
        SeleniumHelper.waitForElementToBeClickable(driver,bestWayCheckBox);
        bestWayCheckBox.click();
        SeleniumHelper.waitForElementToBeVisible(driver, nextButton);
        nextButton.click();
        return this;
    }

    public WebElement getPaymentMethod() {
        SeleniumHelper.waitForElementToBeVisible(driver, paymentMethod);
        return paymentMethod;
    }

    public ThankYouForYourOrderPage paymentWithNewUser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SeleniumHelper.waitForElementToBeClickable(driver, placeOrderButton);
        placeOrderButton.click();
        //Low Performance
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ThankYouForYourOrderPage(driver);
    }

    public CheckOutPage shippingAddressWithExistingAccount() {
        SeleniumHelper.waitForElementToBeVisible(driver, defaultAddress);
        SeleniumHelper.waitForElementToBeClickable(driver, bestWayCheckBox);
        bestWayCheckBox.click();
        SeleniumHelper.waitForElementToBeClickable(driver, nextButton);
        nextButton.click();
        //Low Performance
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ThankYouForYourOrderPage paymentWithExistingAccount(){
        SeleniumHelper.waitForElementToBeClickable(driver, placeOrderButton);
        //Low Performance
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        placeOrderButton.click();
        //Low Performance
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ThankYouForYourOrderPage(driver);
    }

}
