package pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class HomePage {

    private BasePage browser;
    private By welcome = By.xpath("//span[text()='Welcome, Veronica Costello!']");
    private By search = By.id("search");

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

    public RegisterPage clickCreatAnAccount(){
        browser.clickLink("Create an Account");
        return new RegisterPage(browser);
    }

    public void addCart (){
        browser.addToCart();
    }

    public void searchTheLowestPrice() {
        browser.searchTheLowestPrice();
    }
}
