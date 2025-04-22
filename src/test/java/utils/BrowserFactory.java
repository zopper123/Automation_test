package utils;

import com.microsoft.playwright.*;

public class BrowserFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;

    public static Page launchBrowser(String browserType, boolean headless) {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless);

        switch (browserType.toLowerCase()) {
            case "chrome":
            case "chromium":
                browser = playwright.chromium().launch(launchOptions);
                break;
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "webkit":
                browser = playwright.webkit().launch(launchOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        context = browser.newContext();
        return context.newPage();
    }

    public static void closeBrowser() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
