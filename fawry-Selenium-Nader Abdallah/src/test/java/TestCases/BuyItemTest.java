package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.LoginPage;
import com.amazon.Utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyItemTest extends TestBase {
    @Test
    public void checkIfAllItemsSelected() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loadWebsite()
                .login()
                .clickOnAll()
                .clickOnFreeShipping()
                .clickOnNewLink()
                .selectDropDown()
                .clickItemLessFifteen();
    }
}
