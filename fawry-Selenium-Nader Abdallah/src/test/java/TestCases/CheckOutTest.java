package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends TestBase {
    @Test
    public void validateAddress() {
        LoginPage loginPage = new LoginPage(driver);
        double TotalOrderPrice = loginPage
                .loadWebsite()
                .login()
                .clickOnAll()
                .clickOnFreeShipping()
                .clickOnNewLink()
                .selectDropDown()
                .clickItemLessFifteen()
                .proceedToBuy()
                .addAddress()
                .setPaymentMethod()
                .totalOrder();

        Assert.assertEquals(TotalOrderPrice
                , driver.findElement(By.xpath("//td[contains(text(),'EGP 8,781.00')]"))
                        .getText()
                        .replaceAll("[^0-9]" , ""));
    }
}
