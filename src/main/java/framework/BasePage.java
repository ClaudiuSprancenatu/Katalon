package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    private WebDriver driver;
    private Integer timeout = 10; // number of tries
    private int waitPerTry = 500; // milliseconds to wait on each try

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private String baseUrl = System.getProperty("baseUrl", "System baseUrl is not defined");

    public void visit(String url) {
        System.out.println("Navigating to: " + url);
        if (!url.contains("http")) {
            url = baseUrl + url;
        }
        System.out.println("<> " + url);
        driver.get(url);
    }

    public void clickLink(String text) {
        waitForThePageToBeLoaded();
        driver.findElement(By.linkText(text)).click();
    }

    public void click(By selector) {
        try {
            waitUntilIsClickable(selector).click();
        } catch (StaleElementReferenceException s) {
            find(selector).click();
        }
    }

    public String getMessage(By selector) {

        return driver.findElement(selector).getText();
    }

    public void typeIn(String text, By selector) {
        waitUntilIsVisible(selector);
        waitForThePageToBeLoaded();
        find(selector).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
        find(selector).clear();
        find(selector).sendKeys(text);
    }

    public void search(String text, By selector) {
        find(selector).sendKeys(text);
        find(selector).submit();
    }

    public WebElement find(By selector) {
        waitForThePageToBeLoaded();
        WebElement node;
        try {
            node = driver.findElement(selector);
            node.getTagName();
        } catch (StaleElementReferenceException s) {
            node = driver.findElement(selector);
        }
        return node;
    }

    public void sleep(Integer miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException in) {
        }
    }

    // WAITS METHODS

    public void waitForThePageToBeLoaded() {
        new WebDriverWait(driver, 5).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }


    public WebElement waitUntilIsClickable(By element) {
        try {
            waitFor(ExpectedConditions.elementToBeClickable(find(element)), timeout);
        } catch (Exception e) {

        }
        return find(element);
    }

    public WebElement waitForElement(By selector) {
        waitFor(ExpectedConditions.presenceOfElementLocated(selector), timeout);
        return driver.findElement(selector);
    }

    public void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : this.timeout;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public WebElement waitUntilIsVisible(By selector) {
        // TODO - to do some more testing

        Integer i = 0;
        WebElement node;
        String stacktrace = null;
        while (i < timeout) {
            try {
                node = find(selector);
            } catch (Exception e) {
                node = null;
                stacktrace = e.getMessage();
                i++;
                sleep(waitPerTry);
            }
            if (node != null) {
                if (node.isDisplayed()) {
                    return node;
                }
            }
        }

        throw new NoSuchElementException(String.format("Element %s not found or not visible until %d seconds passed!",
                selector, timeout) + "\r\n" + stacktrace);
    }

    public void addToCart () {
        List<WebElement> elements = driver.findElements(By.cssSelector("[data-product_id]"));
        List<Integer> addedNumbers = new ArrayList<>();
        while (true) {
            Random random = new Random();
            int nr = random.nextInt(6);
            if (!addedNumbers.contains(nr)) {
                elements.get(nr).click();
                addedNumbers.add(nr);
            }
            if (addedNumbers.size() == 4){
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchTheLowestPrice() {
        List<WebElement> elements = driver.findElements(By.className("woocommerce-cart-form__cart-item"));
        float min = Float.MAX_VALUE;
        WebElement minElement = null;
        for (int i = 0; i < elements.size(); i++){
                var priceText = elements.get(i).findElement(By.className("product-subtotal")).getText();
                float price = Float.parseFloat(priceText.substring(1));
                if (price < min){
                    min = price;
                    minElement = elements.get(i).findElement(By.className("remove"));
                }
        }
        minElement.click();
    }
}