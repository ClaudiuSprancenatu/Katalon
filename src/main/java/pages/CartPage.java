package pages;

import framework.BasePage;

public class CartPage {
    private BasePage browser;

    public CartPage(BasePage browser) {
        this.browser = browser;
    }

    public void iCanSeeCartPage() {
        browser.iCanSeeCartPage();
    }

    public void addCart() {
        browser.addToCart();
    }

    public void removeTheMaximPrice() {
        browser.removeTheMaximPrice();
    }

    public void removeTheLowestPrice() {
        browser.removeTheLowestPrice();
    }
}
