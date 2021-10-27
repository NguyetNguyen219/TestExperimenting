package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class SeleniumBaseGoogleTest extends BaseTest {

    @BeforeTest
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://google.com");
    }

    @AfterTest
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
