package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchResultPage {
    @FindBy(css = ".base")
    private WebElement searchResultFor;

    @FindBy(css = "li.product-item")
    private List<WebElement> searchResultsNames;

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement getSearchResultFor(){
        SeleniumHelper.waitForElementToBeVisible(driver, searchResultFor);
        return searchResultFor;
    }

    public List<String> getProductsSearchName() {
        List<String> productName = new ArrayList<>();
        for (WebElement element : searchResultsNames) {
            productName.add(element.getText());
        }
        return productName;
    }

    public WebElement getRandomSearchProductElement(){
        Random random = new Random();
        return searchResultsNames.get(random.nextInt(searchResultsNames.size()));
    }

    public String getSearchProductNameFormElement(WebElement productElement) {
        return productElement.findElement(By.cssSelector("strong.product-item-name a")).getText().trim();
    }

    public ProductDetailPage clickSearchProductImage(WebElement productElement) {
        WebElement imageElement = productElement.findElement(By.cssSelector("a.product-item-photo"));
        new Actions(driver).moveToElement(imageElement).click().perform();
        return new ProductDetailPage(driver);
    }

}
