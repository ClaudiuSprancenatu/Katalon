package pages;

import framework.BasePage;

public class HomePage {

    private BasePage browser;

    public HomePage(BasePage browser){
        this.browser = browser;
    }

    public HomePage open (){
        browser.visit("https://cms.demo.katalon.com/");
        return this;
    }

    public void clickLinkText (String text){
        browser.clickLink(text);
    }

    public void addCart (){
        browser.addToCart();
    }

    public void removeTheLowestPrice() {
        browser.removeTheLowestPrice();
    }
}
