package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private BasePage basePage;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver){
        basePage = new BasePage(driver);
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(basePage) : homePage;
    }

}
