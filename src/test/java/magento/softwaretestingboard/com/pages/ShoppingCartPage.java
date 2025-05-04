package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage {
    @FindBy(css = ".base")
    private WebElement shoppingCart;

    @FindBy(css = "td[class='col item'] div[class='product-item-details'] a")
    private List<WebElement> nameProducts;

    @FindBy(css = "td.col.price span.price")
    private List<WebElement> productsPrices;

    @FindBy(css = "input.input-text.qty[data-role='cart-item-qty']")
    private List<WebElement> productsQty;

    @FindBy(css = "td.col.subtotal span.price")
    private List<WebElement> productsSubtotal;

    @FindBy(css = "button[data-role='proceed-to-checkout']")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getShoppingCart() {
        SeleniumHelper.waitForElementToBeVisible(driver, shoppingCart);
        return shoppingCart;
    }

    public List<String> getNameProducts() {
        return nameProducts.stream()
                .map(WebElement :: getText)
                .collect(Collectors.toList());
    }

    public List<String> getProductsPrices() {
        return productsPrices.stream()
                .map(WebElement :: getText)
                .collect(Collectors.toList());
    }

    public List<String> getProductsQty() {
        return productsQty.stream()
                .map(e -> e.getAttribute("value").trim())
                .collect(Collectors.toList());
    }

    public List<String> getProductsSubtotal() {
        return productsSubtotal.stream()
                .map(WebElement :: getText)
                .collect(Collectors.toList());
    }

    public CheckOutPage proceedToCheckoutButtonClick() {
        proceedToCheckoutButton.click();
        return new CheckOutPage(driver);
    }

}
