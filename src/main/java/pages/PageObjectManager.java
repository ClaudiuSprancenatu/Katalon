package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private BasePage basePage;
    private HomePage homePage;
    private CartPage cartPage;
    private SamplePage samplePage;

    public PageObjectManager(WebDriver driver) {
        basePage = new BasePage(driver);
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(basePage) : homePage;
    }
    public SamplePage getSamplePage() {
        return (samplePage == null) ? samplePage = new SamplePage(basePage) : samplePage;
    }
    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(basePage) : cartPage;
    }

}
