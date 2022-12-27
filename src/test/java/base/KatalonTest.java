package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class KatalonTest extends BaseTests {

    private HomePage homePage;
    private CartPage cartPage;
    private SamplePage samplePage;

    @BeforeMethod
    public void setPages() {
        homePage = pages.getHomePage();
        cartPage = pages.getCartPage();
        samplePage = pages.getSamplePage();
    }

    @Test
    public void testKatalon() {
        homePage.open();
        cartPage.addCart();
        homePage.clickToCart();
        cartPage.iCanSeeCartPage();
        cartPage.removeTheMaximPrice();
        homePage.clickToSamplePage();
        samplePage.iCanSeeSamplePage();
    }

}
