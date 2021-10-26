package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseGoogleTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://google.com");
    }

    @AfterMethod
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
