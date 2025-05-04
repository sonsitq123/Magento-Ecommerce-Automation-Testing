package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductDetailPage {

    // detailProduct
    @FindBy(css = "h1.page-title > span.base")
    private WebElement detailProductName;

    @FindBy(css = "span.price")
    private WebElement productPrice;

    @FindBy(css = "div.swatch-attribute.size div.swatch-option.text")
    private List<WebElement> sizeProduct;

    @FindBy(css = "div.swatch-attribute.color div.swatch-option.color")
    private List<WebElement> colorProduct;

    @FindBy(css = "#qty")
    private WebElement quantityInPut;

    @FindBy(css = "#product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(css = "div.message-success.success.message > div")
    private WebElement addToCartMessage;

    //cart
    @FindBy(css = ".action.showcart")
    private WebElement cartButton;

    @FindBy(css = "#minicart-content-wrapper")
    private WebElement cartContent;

    @FindBy(css = "#btn-minicart-close")
    private WebElement cartCloseButton;

    @FindBy(css = "a[title='Remove item']")
    private WebElement removeProductButton;

    @FindBy(css = ".action.viewcart")
    private WebElement viewAndEditCartButton;

    //removeProductFromCart
    @FindBy(css = ".action-primary.action-accept")
    private WebElement okRemoveFromCartButton;

    @FindBy(css = ".subtitle.empty")
    private WebElement notProductInCartMessage;

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAddToCartMessage(){
        SeleniumHelper.waitForElementToBeVisible(driver, addToCartMessage);
        return addToCartMessage;
    }

    public WebElement getDetailProductName() {
        SeleniumHelper.waitForElementToBeVisible(driver, detailProductName);
        return detailProductName;
    }

    public WebElement getPriceProduct() {
        SeleniumHelper.waitForElementToBeVisible(driver, productPrice);
        return productPrice;
    }

    public List<WebElement> getSizeProduct() {
        return sizeProduct != null ? sizeProduct : new ArrayList<>();
    }

    public List<WebElement> getColorProduct() {
        return colorProduct != null ? colorProduct : new ArrayList<>();
    }

    public WebElement getQuantity() {
        return quantityInPut;
    }

    public WebElement getAddToCartButton() {
        SeleniumHelper.waitForElementToBeClickable(driver, addToCartButton);
        return addToCartButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    private boolean areElementsDisplayed(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) return false;
        for (WebElement element : elements) {
            if (!element.isDisplayed()) return false;}
        return true;
    }

    public boolean isProductDetailDisplayed() {
        return (!getSizeProduct().isEmpty() ? areElementsDisplayed(getSizeProduct()) : true) &&
                (!getColorProduct().isEmpty() ? areElementsDisplayed(getColorProduct()) : true) &&
                getQuantity().isDisplayed() &&
                getAddToCartButton().isDisplayed();
    }

    public void selectRandomSizeProduct() {
        List<WebElement> sizes = getSizeProduct();
        if (sizes == null || sizes.isEmpty() || !areElementsDisplayed(sizes)) return;
        int randomIndex = new Random().nextInt(sizes.size());
        WebElement elementToClick = sizes.get(randomIndex);
        SeleniumHelper.waitForElementToBeClickable(driver, elementToClick);
        elementToClick.click();
    }


    public void selectRandomColor() {
        List<WebElement> colors = getColorProduct();
        if (colors == null || colors.isEmpty() || !areElementsDisplayed(colors)) return;
        int randomIndex = new Random().nextInt(colors.size());
        WebElement elementToClick = colors.get(randomIndex);
        SeleniumHelper.waitForElementToBeClickable(driver, elementToClick);
        elementToClick.click();
    }

    public ProductDetailPage addProductInCart(String quantityProduct) {
        selectRandomSizeProduct();
        selectRandomColor();
        quantityInPut.clear();
        quantityInPut.sendKeys(quantityProduct);
        addToCartButton.click();
        return this;
    }

    public ProductDetailPage removeProductFromCart() {
        cartButton.click();
        SeleniumHelper.waitForElementToBeClickable(driver,removeProductButton);
        removeProductButton.click();
        SeleniumHelper.waitForElementToBeClickable(driver,okRemoveFromCartButton);
        okRemoveFromCartButton.click();
        return this;
    }

    public WebElement getNotProductInCartMessage() {
        SeleniumHelper.waitForElementToBeVisible(driver, notProductInCartMessage);
        return notProductInCartMessage;
    }

    public ShoppingCartPage viewAndEditCartButtonClick() {
        SeleniumHelper.waitForElementToBeClickable(driver, cartButton);
        cartButton.click();
        SeleniumHelper.waitForElementToBeClickable(driver,viewAndEditCartButton);
        viewAndEditCartButton.click();
        return new ShoppingCartPage(driver);
    }

}
