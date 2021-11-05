package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredCharacterListTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;

    private void setup() {
        specBuilder.setBaseUri("https://the-one-api.dev/v2/character")
                .addHeader("Authorization", "Bearer xBhaWGa0iqYjMoWKz6O8")
                .addParam("limit", "100");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testNumberOfCharacter() {
        LOGGER.info("");
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().log().body()
                .body("total", equalTo(933));
    }

    @Test
    public void testLimitNumberOfCharacter() {
        LOGGER.info("");

        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().body("limit", equalTo(100));
    }
}
