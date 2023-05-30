package com.amazon.Pages;

import com.amazon.Base.PageBase;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-main']/div[1]/a[1]/i[1]")
    private WebElement AllButton;

    @FindBy(xpath = "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[14]/a[1]")
    private WebElement seeAll;

    @FindBy(xpath = "//div[contains(text(),'Video Games')]")
    private WebElement videoGames;

    @FindBy(xpath = "//a[contains(text(),'All Video Games')]")
    private WebElement allVideoGames;
    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement loginAssertions;







    public VideoGamesPage clickOnAll(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(AllButton));
        AllButton.click();
        wait.until(ExpectedConditions.visibilityOf(seeAll));
        seeAll.click();
        wait.until(ExpectedConditions.visibilityOf(videoGames));
        videoGames.click();
        wait.until(ExpectedConditions.visibilityOf(allVideoGames));
        allVideoGames.click();

        return new  VideoGamesPage(driver);
    }
    public boolean loginAssertion(){
        return loginAssertions.isDisplayed();
    }
}
