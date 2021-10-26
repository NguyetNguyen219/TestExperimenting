package com.nguyen.experimenting.restAssured44.weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTimezoneTest extends RestAssuredWeatherBaseTest {

    private Response response = null;
    private LocalDateTime dateTime = null;

    public void setup() {
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Lyon");
    }

    @Test
    public void testStatusCode() {
        response = RestAssured.given(specBuilder.build()).get("/timezone.json");
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Lyon"));
    }

    @Test
    public void testLocalTime() {
        dateTime = LocalDateTime.now(ZoneId.of("Europe/Paris"));
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        response = RestAssured.given(specBuilder.build()).get("/timezone.json");
        response.then().assertThat()
                .body("location.localtime", equalTo(date));
    }

    @Test
    public void testTimeZoneId() {
        response = RestAssured.given(specBuilder.build()).get("/timezone.json");
        response.then().assertThat()
                .body("location.tz_id", equalTo("Europe/Paris"));
    }
}