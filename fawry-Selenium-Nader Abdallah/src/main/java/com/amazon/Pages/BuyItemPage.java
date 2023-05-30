//package com.amazon.Pages;
//
//import com.amazon.Base.PageBase;
//import com.amazon.Utils.ConfigUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//public class BuyItemPage extends PageBase {
//
//
//    private final By inventoryItemsPrice = By.xpath("//span[@class=\"a-price-whole\"]");
//    private final By AddToCartButton = By.id("add-to-cart-button");
//    private final By noThanksButton = By.xpath("(//div[@class=\"a-button-stack\"]//span[text()=\" No Thanks \"]/preceding-sibling::input[@type=\"submit\"])[1]");
//    public static int noOfPriceElements;
//
//    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='sw-full-view-container']/div[@id='sw-full-view']/div[@id='sw-atc-confirmation']/div[@id='sw-atc-actions']/div[@id='sw-atc-fst-buybox']/div[@id='sw-atc-bb']/div[@id='sw-atc-buy-box']/form[@id='sw-ptc-form']/span[@id='desktop-ptc-button-celWidget']/span[@id='sc-buy-box-ptc-button']/span[1]/input[1]")
//    private WebElement proceedToBuy;
//
//    public BuyItemPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public BuyItemPage clickItemLessFifteen() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"a-price-whole\"]")));
//
//        List<WebElement> priceElements = driver.findElements(inventoryItemsPrice);
//        noOfPriceElements = priceElements.size();
//
//        for (int i = 0; i < priceElements.size(); i++) {
//            priceElements = driver.findElements(inventoryItemsPrice);
//            int price = Integer.parseInt(priceElements.get(i).getText().replace(",", ""));
//            if (price < 15000) {
//                WebElement temp = priceElements.get(i);
//                wait.until(ExpectedConditions.visibilityOf(temp));
//                temp.click();
//                wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
//                driver.findElement(AddToCartButton).click();
//                try {
//                    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(noThanksButton));
//                    driver.findElement(noThanksButton).click();
//                    wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
//                } catch (Exception e) {
//                }
//                driver.navigate().to(ConfigUtils.getInstance().getItemsUrl());
//            }
//        }
//        return this;
//    }
//    public CheckoutPage proceedToBuy(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(proceedToBuy));
//        proceedToBuy.click();
//        return new CheckoutPage(driver);
//
//    }
//
//}


package com.amazon.Pages;

import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuyItemPage extends PageBase {
    public BuyItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='a-page']/div[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/span[1]/span[1]/span[1]/input[1]")
    private WebElement proceedToBuy;

    @FindBy(css = "#nav-cart-count")
    private WebElement cartIcon;



    private By freeShippingCheckBox = By.xpath("//div[@class=\"a-checkbox a-checkbox-fancy aok-float-left apb-browse-refinements-checkbox\"]//i[@class=\"a-icon a-icon-checkbox\"]");
    private By newCondition = By.xpath("//li[@id=\"p_n_condition-type/28071525031\"]//span[@class=\"a-size-base a-color-base\"]");
    //    private By sortList = By.xpath("//span[@class=\"a-button-text a-declarative\"]");
    private By sortList = By.xpath("//span[contains(text(),'Sort by:')]");
    private By highToLowSelection = By.xpath("//a[text()=\"Price: High to Low\"]");
    private By inventoryItemsPrice= By.xpath("//span[@class=\"a-price-whole\"]");

    private By AddToCartButton = By.id("add-to-cart-button");
    private By itemAddedLabel = By.xpath("//span[contains(text(), 'Added to Cart')]");
    private By sortingType = By.xpath("//span[text()=\"Price: High to Low\"]");
    private By noThanksButton = By.xpath("(//div[@class=\"a-button-stack\"]//span[text()=\" No Thanks \"]/preceding-sibling::input[@type=\"submit\"])[1]");

    public BuyItemPage clickItemLessFifteen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"a-price-whole\"]")));

        List<WebElement> priceElements = driver.findElements(inventoryItemsPrice);
        for(int i=0 ; i<priceElements.size();i++){
            priceElements = driver.findElements(inventoryItemsPrice);
            int price = Integer.parseInt(priceElements.get(i).getText().replace(",", ""));
            if (price < 15000) {
                WebElement temp =priceElements.get(i);
                wait.until(ExpectedConditions.visibilityOf(temp));
                temp.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
                driver.findElement(AddToCartButton).click();
                try{
                    new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(noThanksButton));
                    driver.findElement(noThanksButton).click();
                    Thread.sleep(Long.parseLong("1000"));
                    driver.findElement(AddToCartButton).click();
                }catch(Exception e){

                }
                driver.navigate().to(ConfigUtils.getInstance().getItemsUrl());


            }
        }
        return this;
    }
    public CheckoutPage proceedToBuy(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();

        wait.until(ExpectedConditions.visibilityOf(proceedToBuy));
        proceedToBuy.click();

        return new CheckoutPage(driver);

    }




}