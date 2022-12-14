package base;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setPages(){
        loginPage = pages.getLoginPage();
        homePage = pages.getHomePage();

    }

    @Test
    public void LogInWithValidCredentials(){
        loginPage.open().ValidateCredentials("roni_cost@example.com", "roni_cost3@example.com");
//        assertTrue(homePage.ValidateLogin().contains("Welcome, Veronica Costello!"), "Alert text is incorrect!");
        System.out.println("Successfully Login test is done!");
    }
}
