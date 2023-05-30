package com.amazon.Pages;

import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='a-page']/div[@id='sw-full-view-container']/div[@id='sw-full-view']/div[@id='sw-atc-confirmation']/div[@id='sw-atc-actions']/div[@id='sw-atc-fst-buybox']/div[@id='sw-atc-bb']/div[@id='sw-atc-buy-box']/form[@id='sw-ptc-form']/span[@id='desktop-ptc-button-celWidget']/span[@id='sc-buy-box-ptc-button']/span[1]/input[1]")
    private WebElement proceedToBuy;

    @FindBy(xpath = "//a[@id='addressChangeLinkId']")
    private WebElement changeAddressButton;

    @FindBy(id = "add-new-address-popover-link")
    private WebElement addNewAddress;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    private WebElement streetName;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enter-building-name-or-number']")
    private WebElement buildingName;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    private WebElement cityArea;

    @FindBy(xpath = "//body/div[8]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[12]/ul[1]/li[1]")
    private WebElement subCityArea;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressDistrictOrCounty']")
    private WebElement DistrictField;

    @FindBy(xpath = "//li[contains(text(),'Abdeen-As Saqayin')]")
    private WebElement subDistrict;

    @FindBy(xpath = "//input[@id='address-ui-widgets-landmark']")
    private WebElement nearestLandMark;

    @FindBy(xpath = "//input[@id='address-ui-widgets-addr-details-res-radio-input']")
    private WebElement radioButton;

    @FindBy(xpath = "//body/div[8]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]/span[1]/span[1]/input[1]")
    private WebElement addAddressButton;

    @FindBy(id = "payChangeButtonId")
    private WebElement changePaymentButton;

    @FindBy(id = "pp-AxOlCE-86")
    private WebElement CODRadioButton;

    @FindBy(xpath = "//body/div[@id='a-page']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/span[1]/span[1]/input[1]")
    private WebElement useThisMethodButton;


    @FindBy(xpath = "//td[contains(text(),'EGP 8,769.00')]")
    private WebElement totalAmountOfOrder;

    private String totalOrder;
    private double orderPrice;
    private double shipping;
    private double promotions;
    private double finalAmount;

    public CheckoutPage addAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(changeAddressButton));
        changeAddressButton.click();
        wait.until(ExpectedConditions.visibilityOf(addNewAddress));
        addNewAddress.click();
        wait.until(ExpectedConditions.visibilityOf(fullNameField));
        fullNameField.sendKeys(ConfigUtils.getInstance().getFullName());
        phoneNumberField.sendKeys(ConfigUtils.getInstance().getMobileNumber());
        streetName.sendKeys(ConfigUtils.getInstance().getStreetName());
        buildingName.sendKeys(ConfigUtils.getInstance().getBuildingNo());
        cityArea.sendKeys(ConfigUtils.getInstance().getCityName());
        wait.until(ExpectedConditions.visibilityOf(DistrictField));
        DistrictField.sendKeys(ConfigUtils.getInstance().getDistrict());
        nearestLandMark.sendKeys(ConfigUtils.getInstance().getNearestLandmark());
        radioButton.click();
        addAddressButton.click();
        return this;
    }

    public CheckoutPage setPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(changePaymentButton));
        changePaymentButton.click();
        wait.until(ExpectedConditions.visibilityOf(CODRadioButton));
        CODRadioButton.click();
        wait.until(ExpectedConditions.visibilityOf(useThisMethodButton));
        useThisMethodButton.click();

        return this;
    }

    public double totalOrder() {
        shipping = 78;
        promotions = -26;
        totalOrder = totalAmountOfOrder.getText().replace("[^0-9]",  "");
        orderPrice = Double.parseDouble(totalOrder);
        finalAmount = orderPrice + shipping + promotions;
        return  finalAmount;



    }


}
