package com.nguyen.experimenting.tool;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.WebDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * class Helper contains static variables & methods
 * help write Selenium test case
 */
public final class Helper {

    private static WebDriver driver = DriverWrapper.getDriver();

    public static int AVERAGE_WAIT_TIME = 8;
    /**
     * Time wait for visibility of elements
     */
    public static int ELEMENT_VISIBLE_TIME = 5;
    /**
     * Time wait for elements to be clickable
     */
    public static int ELEMENT_CLICKABLE_TIME = 8;
    /**
     * Time wait for the page to load
     */
    public static int PAGE_LOADING_TIME = 10;

    /**
     * implicit wait for visibility of element
     */
    public static void implicitWaitForElementVisibility() {
        driver.manage().timeouts().implicitlyWait(ELEMENT_VISIBLE_TIME, SECONDS);
    }

    /**
     * implicit wait for page loading
     */
    public static void implicitWaitForPageLoading() {
        driver.manage().timeouts().implicitlyWait(PAGE_LOADING_TIME, SECONDS);
    }

    /**
     * implicit wait for element to be clickable
     */
    public static void implicitWaitForClickableElement() {
        driver.manage().timeouts().implicitlyWait(ELEMENT_CLICKABLE_TIME, SECONDS);
    }
}
