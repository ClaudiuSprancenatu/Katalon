package pages;

import framework.BasePage;

public class HomePage {

    private BasePage browser;

    public HomePage(BasePage browser) {
        this.browser = browser;
    }

    public HomePage open() {
        browser.visit("https://cms.demo.katalon.com/");
        return this;
    }

    public void clickToCart() {
        browser.clickToCart();
    }

    public void clickToSamplePage() {
        browser.clickToSamplePage();
    }
}
