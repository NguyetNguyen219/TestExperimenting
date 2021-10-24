package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredMovieTest extends RestAssuredBaseTest {

    private Response response = null;
    private String movieId = "5cd95395de30eff6ebccde58";

    @BeforeMethod
    public void setupGet() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2")
                .setBasePath("movie/" + movieId)
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8");
        // Get the response
        response = RestAssured.given(specBuilder.build()).get();
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testMovieId() {
        response.then().assertThat().log().all()
                .body("docs[0]._id", equalTo(movieId));
    }

    @Test
    public void testMovieName() {
        response.then().assertThat()
                .body("docs[0].name", equalTo("The Unexpected Journey"));
    }

    @Test
    public void testMovieAwardWin() {
        response.then().assertThat()
                .body("docs[0].academyAwardWins", equalTo(1));
    }

    @Test
    public void testMovieTotal() {
        response.then().assertThat()
                .body("total", equalTo(1));
    }
}
