package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;
    private String movieId = "5cd95395de30eff6ebccde58";

    private void setup() {
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie/" + movieId)
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testMovieId() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().log().all()
                .body("docs[0]._id", equalTo(movieId));
    }

    @Test
    public void testMovieName() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat()
                .body("docs[0].name", equalTo("The Unexpected Journey"));
    }

    @Test
    public void testMovieAwardWin() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat()
                .body("docs[0].academyAwardWins", equalTo(1));
    }

    @Test
    public void testMovieTotal() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat()
                .body("total", equalTo(1));
    }
}
