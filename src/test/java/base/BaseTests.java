package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageObjectManager;

public class BaseTests {
    private WebDriver driver;
    public PageObjectManager pages;

    @BeforeMethod
    public void SetUp(){
        System.setProperty("baseUrl","https://cms.demo.katalon.com/");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pages = new PageObjectManager(driver);
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
