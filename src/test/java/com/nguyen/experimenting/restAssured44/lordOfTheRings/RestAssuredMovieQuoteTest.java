package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieQuoteTest extends RestAssuredBaseTest {

    private Response response = null;
    private String movieId = "5cd95395de30eff6ebccde57";

    @BeforeMethod
    public void setupGet() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie/" + movieId + "/quote")
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");
        // Get the response
        response = RestAssured.given(specBuilder.build()).get();
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfQuote() {
        response.then().assertThat().log().body()
                .body("total", equalTo(0));
    }
}
