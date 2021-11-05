package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import com.nguyen.experimenting.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.*;

public abstract class RestAssuredLordOfTheRingBaseTest extends BaseTest {

    RequestSpecBuilder specBuilder;

    @BeforeMethod
    public void initialize() {
        specBuilder = new RequestSpecBuilder();
    }

    @AfterMethod
    public void close() {
        specBuilder = null;
    }
}
