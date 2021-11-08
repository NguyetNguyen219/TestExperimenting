package com.nguyen.experimenting.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nguyen.experimenting.tool.Helper.*;

public class DriverWrapper {

    private static WebDriver driver = null;
    private static WebDriverWait wait = null;

    private DriverWrapper() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=es");

        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(options);

        driver = new ChromeDriver(service);
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            new DriverWrapper();
        }
        return driver;
    }

    /**
     * method returns the driver wait in AVERAGE_WAIT_TIME seconds
     * @return WedDriverWait
     */
    public static WebDriverWait getDriverWait() {
        if(wait == null)
            wait = new WebDriverWait(driver, AVERAGE_WAIT_TIME);
        return wait;
    }
}
