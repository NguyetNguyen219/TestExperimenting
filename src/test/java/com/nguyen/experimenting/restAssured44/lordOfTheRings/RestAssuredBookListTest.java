package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredBookListTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;

    private void setup() {
        specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2/book");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfBook() {
        LOGGER.info("Test number ////*");

        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().log().all().body("total", equalTo(3));
    }
}
