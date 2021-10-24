package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieListTest extends RestAssuredBaseTest {

    private RequestSpecBuilder specBuilder = null;
    private Response response = null;

    @BeforeMethod
    public void setupGet() {
        specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie")
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");

        // Get the response
        response = RestAssured.given(specBuilder.build()).get();
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfMovie() {
        log.info("");

        response.then().assertThat().log().all().body("total", equalTo(8));
    }
}
