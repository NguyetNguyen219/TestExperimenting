package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieQuoteTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;
    private String movieId = "5cd95395de30eff6ebccde57";

    private void setup() {
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie/" + movieId + "/quote")
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfQuote() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().log().body()
                .body("total", equalTo(0));
    }
}
