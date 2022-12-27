package pages;

import framework.BasePage;

public class SamplePage {

    private BasePage browser;

    public SamplePage(BasePage browser) {
        this.browser = browser;
    }

    public void iCanSeeSamplePage() {
        browser.iCanSeeSamplePage();
    }
}
