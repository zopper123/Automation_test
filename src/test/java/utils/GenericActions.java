package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;

import java.nio.file.Paths;

public class GenericActions {

    private final Page page;

    public GenericActions(Page page) {
        this.page = page;
    }

    // Basic Actions
    public void click(String selector) {
        page.locator(selector).click();
    }

    public void type(String selector, String text) {
        page.locator(selector).fill(text);
    }

    public String getText(String selector) {
        return page.locator(selector).textContent();
    }

    public boolean isVisible(String selector) {
        return page.locator(selector).isVisible();
    }

    public void waitForSelector(String selector) {
        page.waitForSelector(selector);
    }

    public void clearAndType(String selector, String text) {
        Locator element = page.locator(selector);
        element.clear();
        element.fill(text);
    }

    public String getAttribute(String selector, String attribute) {
        return page.locator(selector).getAttribute(attribute);
    }

    public void selectOption(String selector, String value) {
        page.selectOption(selector, value);
    }

    public void hover(String selector) {
        page.locator(selector).hover();
    }

    public void pressKey(String selector, String key) {
        page.locator(selector).press(key);
    }

    public void scrollIntoView(String selector) {
        page.locator(selector).scrollIntoViewIfNeeded();
    }

    public int getElementCount(String selector) {
        return page.locator(selector).count();
    }

    // Screenshot
    public void takeScreenshot(String filePath) {
        page.screenshot(new Page.ScreenshotOptions()
            .setPath(Paths.get(filePath))
            .setType(ScreenshotType.PNG));
    }

    // Dropdown (custom dropdown using click and select from list)
    public void selectFromDropdown(String dropdownSelector, String optionText) {
        Locator dropdown = page.locator(dropdownSelector);
        dropdown.click();
        Locator option = page.locator("text=" + optionText);
        option.click();
    }

    // Calendar (assumes click opens calendar and day is selectable by text)
    public void selectDate(String calendarSelector, String day) {
        page.locator(calendarSelector).click(); // opens the calendar
        page.locator("text=\"" + day + "\"").click(); // clicks on the date
    }

    // Drag and Drop
    public void dragAndDrop(String sourceSelector, String targetSelector) {
        Locator source = page.locator(sourceSelector);
        Locator target = page.locator(targetSelector);
        source.dragTo(target);
    }

    // Calendar with month/year navigation
public void selectDateWithNavigation(String calendarOpenSelector, String headerSelector,
String nextButtonSelector, String targetMonthYear,
String daySelectorPattern, String targetDay) {

page.locator(calendarOpenSelector).click();

while (!page.locator(headerSelector).textContent().trim().equalsIgnoreCase(targetMonthYear)) {
page.locator(nextButtonSelector).click();
}

page.locator(daySelectorPattern.replace("{DAY}", targetDay)).click();
}

// Element screenshot
public void takeElementScreenshot(String selector, String filePath) {
page.locator(selector).screenshot(
new Locator.ScreenshotOptions().setPath(Paths.get(filePath))
);
}

}
