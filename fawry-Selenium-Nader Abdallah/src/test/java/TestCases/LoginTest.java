package TestCases;

import com.amazon.Base.TestBase;
import com.amazon.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginToWebSite() {
        LoginPage loginPage = new LoginPage(driver);
        boolean loginAssert = loginPage
                .loadWebsite()
                .login()
                .loginAssertion();
        Assert.assertTrue(loginAssert);
    }
}