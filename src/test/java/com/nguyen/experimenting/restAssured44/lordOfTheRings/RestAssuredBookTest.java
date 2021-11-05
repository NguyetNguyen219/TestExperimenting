package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredBookTest extends RestAssuredLordOfTheRingBaseTest {

    private Response response = null;
    private String bookId = "5cf5805fb53e011a64671582";

    private void setup() {
        specBuilder.setBaseUri("https://the-one-api.dev/v2/book")
                .setBasePath(bookId);
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testBookId() {
        LOGGER.info("#&%^(#/");

        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat().log().all()
                .body("docs[0]._id", equalTo(bookId));
    }

    @Test
    public void testBookName() {
        LOGGER.info("");

        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat()
                .body("docs[0].name", equalTo("The Fellowship Of The Ring"));
    }

    @Test
    public void testBookTotal() {
        LOGGER.info("");

        setup();
        response = RestAssured.given(specBuilder.build()).get();
        response.then().assertThat()
                .body("total", equalTo(1));
    }
}
