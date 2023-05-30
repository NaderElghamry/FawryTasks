package com.amazon.Pages;

import com.amazon.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoGamesPage extends PageBase {
    public VideoGamesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[contains(text(),'Video Games')]")
    private WebElement videoGameText;

    @FindBy(xpath = "//body/div[@id='a-page']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]")
    private WebElement freeShipping;

    @FindBy(xpath = "//span[contains(text(),'Results')]")
    private WebElement ResultsText;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[7]/ul[2]/span[1]/li[1]/span[1]/a[1]/span[1]")
    private WebElement NewTextLink;

    @FindBy(xpath = "//span[contains(text(),'Sort by:')]")
    private WebElement dropdown;

    @FindBy(linkText = "Price: High to Low")
    private WebElement priceHighToLow;

    public boolean videoGameTextIsDisplayed() {
        return videoGameText.isDisplayed();
    }

    public VideoGamesPage clickOnFreeShipping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(freeShipping));
        freeShipping.click();
        return this;
    }

    public boolean resultTextIsDisplayed() {
        return ResultsText.isDisplayed();
    }

    public VideoGamesPage clickOnNewLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(NewTextLink));
        NewTextLink.click();
        return this;
    }
    public BuyItemPage selectDropDown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        dropdown.click();
        wait.until(ExpectedConditions.visibilityOf(priceHighToLow));
        priceHighToLow.click();
        return new BuyItemPage(driver);
    }

}
