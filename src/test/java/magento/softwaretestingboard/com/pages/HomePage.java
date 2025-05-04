package magento.softwaretestingboard.com.pages;

import magento.softwaretestingboard.com.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class HomePage {
    //homePageTitle
    @FindBy(css = ".base")
    private WebElement homePage;

    //sigIn
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement sigInLink;

    //createAccount
    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountLink;

    //search
    @FindBy(css = "#search")
    private WebElement searchProductInput;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @FindBy(css = ".action.showcart")
    private WebElement cartButton;

    //WhatsNew
    @FindBy(css = "#ui-id-3")
    private WebElement whatNewLink;

    //womenMenu
    @FindBy(css = "#ui-id-4")
    private WebElement womenMenu;

    @FindBy(id = "ui-id-9")
    private WebElement womenTops;

    @FindBy(id = "ui-id-11")
    private WebElement womenJackets;

    @FindBy(id = "ui-id-12")
    private WebElement womenHoodiesAndSweatShirts;

    @FindBy(id = "ui-id-13")
    private WebElement womenTees;

    @FindBy(id = "ui-id-14")
    private WebElement womenBrasAndTanks;

    @FindBy(id = "ui-id-10")
    private WebElement womenBottoms;

    @FindBy(id = "ui-id-15")
    private WebElement womenPants;

    @FindBy(id = "ui-id-16")
    private WebElement womenShorts;

    //menMenu
    @FindBy(id = "ui-id-5")
    private WebElement menMenu;

    @FindBy(id = "ui-id-17")
    private WebElement menTops;

    @FindBy(id = "ui-id-19")
    private WebElement menJackets;

    @FindBy(id = "ui-id-20")
    private WebElement menHoodiesAndSweatShirts;

    @FindBy(id = "ui-id-21")
    private WebElement menTees;

    @FindBy(id = "ui-id-22")
    private WebElement menTanks;

    @FindBy(id = "ui-id-18")
    private WebElement menBottoms;

    @FindBy(id = "ui-id-23")
    private WebElement menPants;

    @FindBy(id = "ui-id-24")
    private WebElement menShorts;

    //gearMenu
    @FindBy(id = "ui-id-6")
    private WebElement gearMenu;

    @FindBy(id = "ui-id-25")
    private WebElement bags;

    @FindBy(id = "ui-id-26")
    private WebElement fitnessEquipment;

    @FindBy(id = "ui-id-27")
    private WebElement watches;

    @FindBy(css = "li.product-item")
    private List<WebElement> products;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHomePage() {
        return homePage;
    }

    public CreateAccountPage createAccountClick() {
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }

    public SignInPage signInClick() {
        sigInLink.click();
        return new SignInPage(driver);
    }

    public WhatsNewPage whatsNewPageClick() {
        whatNewLink.click();
        return new WhatsNewPage(driver);
    }
    public WebElement getWomenMenu() {
        return womenMenu;
    }
    public boolean isWomenJacketsDisplayed() {
        return womenJackets.isDisplayed();
    }

    public boolean isWomenHoodiesAndSweatShirtsDisplayed() {
        return womenHoodiesAndSweatShirts.isDisplayed();
    }

    public boolean isWomenTeesDisplayed() {
        return womenTees.isDisplayed();
    }

    public boolean isWomenBrasDisplayed() {
        return womenBrasAndTanks.isDisplayed();
    }

    public void hoverWomenTop() {
        Actions action = new Actions(driver);
        action.moveToElement(womenMenu).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, womenTops);
        action.moveToElement(womenTops).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver,womenJackets);
        SeleniumHelper.waitForElementToBeVisible(driver,womenHoodiesAndSweatShirts);
        SeleniumHelper.waitForElementToBeVisible(driver,womenTees);
        SeleniumHelper.waitForElementToBeVisible(driver,womenBrasAndTanks);
    }

    public boolean isWomenPantsDisplayed(){
        return womenPants.isDisplayed();
    }

    public boolean isWomenShortsDisplayed(){
        return womenShorts.isDisplayed();
    }

    public void hoverWomenBottoms() {
        Actions action = new Actions(driver);
        action.moveToElement(womenMenu).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, womenBottoms);
        action.moveToElement(womenBottoms).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver,womenPants);
        SeleniumHelper.waitForElementToBeVisible(driver,womenShorts);
    }

    public WebElement getMenMenu() {
        return menMenu;
    }

    public boolean isMenJacketsDisplayed() {
        return menJackets.isDisplayed();
    }

    public boolean isMenHoodiesAndSweatShirtsDisplayed() {
        return menHoodiesAndSweatShirts.isDisplayed();
    }

    public boolean isMenTeesDisplayed() {
        return menTees.isDisplayed();
    }

    public boolean isMenTanksDisplayed() {
        return menTanks.isDisplayed();
    }

    public void hoverMenTop() {
        Actions action = new Actions(driver);
        action.moveToElement(menMenu).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, menTops);
        action.moveToElement(menTops).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, menJackets);
        SeleniumHelper.waitForElementToBeVisible(driver, menHoodiesAndSweatShirts);
        SeleniumHelper.waitForElementToBeVisible(driver, menTees);
        SeleniumHelper.waitForElementToBeVisible(driver, menTanks);
    }

    public boolean isMenPantsDisplayed() {
        return menPants.isDisplayed();
    }

    public boolean isMenShortsDisplayed() {
        return menShorts.isDisplayed();
    }

    public void hoverMenBottoms() {
        Actions action = new Actions(driver);
        action.moveToElement(menMenu).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, menBottoms);
        action.moveToElement(menBottoms).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, menPants);
        SeleniumHelper.waitForElementToBeVisible(driver, menShorts);
    }

    public WebElement getGearMenu() {
        return gearMenu;
    }

    public boolean isBagsDisplayed() {
        return bags.isDisplayed();
    }

    public boolean isFitnessEquipmentDisplayed() {
        return fitnessEquipment.isDisplayed();
    }

    public boolean isWatchesDisplayed() {
        return watches.isDisplayed();
    }

    public void hoverGearMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(gearMenu).build().perform();
        SeleniumHelper.waitForElementToBeVisible(driver, bags);
        SeleniumHelper.waitForElementToBeVisible(driver, fitnessEquipment);
        SeleniumHelper.waitForElementToBeVisible(driver, watches);
    }

    public SearchResultPage fillSearchProductInput(String searchProduct) {
        searchProductInput.sendKeys(searchProduct);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public WebElement getRandomHomeProductElement(){
        Random random = new Random();
        return products.get(random.nextInt(products.size()));
    }

    public String getHomeProductNameFormElement(WebElement productElement) {
        return productElement.findElement(By.cssSelector("strong.product-item-name a")).getText();
    }

    public ProductDetailPage clickHomeProductImage(WebElement productElement) {
        WebElement imageElement = productElement.findElement(By.cssSelector("a.product-item-photo"));
        new Actions(driver).moveToElement(imageElement).click().perform();
        return new ProductDetailPage(driver);
    }

}
