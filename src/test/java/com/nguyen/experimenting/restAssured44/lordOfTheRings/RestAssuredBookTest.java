package com.nguyen.experimenting.restAssured44.lordOfTheRings;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredBookTest extends RestAssuredBaseTest {

    private Response response = null;
    private String bookId = "5cf5805fb53e011a64671582";

    @BeforeMethod
    public void setupGet() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.setBaseUri("https://the-one-api.dev/v2/book")
                .setBasePath(bookId);
        // Get the response
        // Default response type: JSON
        response = RestAssured.given(specBuilder.build()).get();
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void testBookId() {
        log.info("");

        response.then().assertThat().log().all()
                .body("docs[0]._id", equalTo(bookId));
    }

    @Test
    public void testBookName() {
        log.info("");

        response.then().assertThat()
                .body("docs[0].name", equalTo("The Fellowship Of The Ring"));
    }

    @Test
    public void testBookTotal() {
        log.info("");

        response.then().assertThat()
                .body("total", equalTo(1));
    }
}
