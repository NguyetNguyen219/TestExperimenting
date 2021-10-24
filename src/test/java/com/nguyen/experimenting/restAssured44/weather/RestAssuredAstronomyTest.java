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

public class RestAssuredAstronomyTest extends RestAssuredBaseTest {

    private String key = "8c89e95bcbb148b1bea32255212410";
    private Response response = null;
    private LocalDateTime dateTime;

    @BeforeMethod
    public void setupGet() {
        dateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));

        //building the request headers
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Tokyo")
                .addParam("dt", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //requesting and saving the response
        response = RestAssured.given(specBuilder.build())
                .get("/astronomy.json");
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Tokyo"));
    }

    @Test
    public void testCountryName() {
        response.then().assertThat()
                .body("location.country", equalTo("Japan"));
    }

    @Test
    public void testTimeZoneId() {
        response.then().assertThat()
                .body("location.tz_id", equalTo("Asia/Tokyo"));
    }

    @Test
    public void testLocalTime() {
        response.then().assertThat()
                .body("location.localtime", equalTo(
                        dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

    @Test
    public void testAstronomy() {
        Assert.assertNotNull(response.body().jsonPath().get("astronomy.astro.sunrise"));
    }
}
