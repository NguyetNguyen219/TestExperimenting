package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseGooglePlayTest {

    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://play.google.com");
    }

    @AfterTest
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
