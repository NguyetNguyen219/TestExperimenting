package com.nguyen.experimenting.restAssured44.weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredCurrentTest extends RestAssuredWeatherBaseTest {

    private Response response = null;
    private LocalDateTime dateTime = null;

    public void setup() {
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Hanoi")
                .addParam("aqi", "no");
    }

    @Test
    public void testStatusCode() {
        setup();
        response = RestAssured.given(specBuilder.build()).get("/current.json");
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        setup();
        response = RestAssured.given(specBuilder.build()).get("/current.json");
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Hanoi"));
    }

    @Test
    public void testTimeZoneId() {
        setup();
        response = RestAssured.given(specBuilder.build()).get("/current.json");
        response.then().assertThat()
                .body("location.tz_id", equalTo("Asia/Ho_Chi_Minh"));
    }

    @Test
    public void testLocalTime() {
        setup();
        dateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        response = RestAssured.given(specBuilder.build()).get("/current.json");
        response.then().assertThat().body("location.localtime", equalTo(date));
    }

    @Test
    public void testCurrentUpdated() {
        setup();
        response = RestAssured.given(specBuilder.build()).get("/current.json");
        Assert.assertNotNull(response.body().jsonPath().get("current.last_updated"));
    }
}
