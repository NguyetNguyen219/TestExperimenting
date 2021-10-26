package com.nguyen.experimenting.restAssured44.weather;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class RestAssuredWeatherBaseTest extends RestAssuredBaseTest {

    protected String key = "8c89e95bcbb148b1bea32255212410";
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
