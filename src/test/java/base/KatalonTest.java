package base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KatalonTest extends BaseTests{

    private HomePage homePage;

    @BeforeMethod
    public void setPages(){
        homePage = pages.getHomePage();
    }

    @Test
    public void testKatalon(){
        homePage.open();
        homePage.addCart();
        //assertEquals(addedItems, 4);
        homePage.clickLinkText("CART");
        homePage.removeTheLowestPrice();
        //assertEquals(remainingItems, 3);
    }

}
