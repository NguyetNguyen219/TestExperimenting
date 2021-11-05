package com.nguyen.experimenting.restAssured44.weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAstronomyTest extends RestAssuredWeatherBaseTest {

    private Response response = null;
    private LocalDateTime dateTime;

    public void setup() {
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Tokyo")
                .addParam("dt", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    @Test
    public void testStatusCode() {
        response = RestAssured.given(specBuilder.build()).get("/astronomy.json");
        Assert.assertEquals(response.statusCode(), 200); //OK

    }

    @Test
    public void testTimeZoneId() {
        response = RestAssured.given(specBuilder.build()).get("/astronomy.json");
        response.then().assertThat()
                .body("location.tz_id", equalTo("Asia/Tokyo"));
    }

    @Test
    public void testLocalTime() {
        dateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        response = RestAssured.given(specBuilder.build()).get("/astronomy.json");
        response.then().assertThat()
                .body("location.localtime", equalTo(
                        dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
    }

    @Test
    public void testAstronomy() {
        response = RestAssured.given(specBuilder.build()).get("/astronomy.json");
        Assert.assertNotNull(response.body().jsonPath().get("astronomy.astro.sunrise"));
    }
}
