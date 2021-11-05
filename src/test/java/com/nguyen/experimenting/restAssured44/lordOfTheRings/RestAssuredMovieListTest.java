package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieListTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;

    private void setup() {
        specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie")
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfMovie() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        LOGGER.info("");

        response.then().assertThat().log().all().body("total", equalTo(8));
    }
}
