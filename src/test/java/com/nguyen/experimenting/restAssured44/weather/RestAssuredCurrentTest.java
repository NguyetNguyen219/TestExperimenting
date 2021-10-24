package com.nguyen.experimenting.restAssured44.weather;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredCurrentTest extends RestAssuredBaseTest {

    private String key = "8c89e95bcbb148b1bea32255212410";
    private Response response = null;
    private LocalDateTime dateTime = null;

    @BeforeMethod
    public void setupGet() {
        //building the request headers
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Hanoi")
                .addParam("aqi", "no");

        dateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        //requesting and saving the response
        response = RestAssured.given(specBuilder.build())
                .get("/current.json");
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Hanoi"));
    }

    @Test
    public void testCountryName() {
        response.then().assertThat()
                .body("location.country", equalTo("Vietnam"));
    }

    @Test
    public void testTimeZoneId() {
        response.then().assertThat()
                .body("location.tz_id", equalTo("Asia/Ho_Chi_Minh"));
    }

    @Test
    public void testLocalTime() {
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        response.then().assertThat().body("location.localtime", equalTo(date));
    }

    @Test
    public void testCurrentUpdated() {
        Assert.assertNotNull(response.body().jsonPath().get("current.last_updated"));
    }
}
