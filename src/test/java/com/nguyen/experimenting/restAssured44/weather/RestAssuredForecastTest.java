package com.nguyen.experimenting.restAssured44.weather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredForecastTest extends RestAssuredWeatherBaseTest {

    private Response response = null;
    private LocalDate dateTime = null;

    @BeforeMethod
    public void setup() {
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Lviv")
                .addParam("days", "1");
    }

    @Test
    public void testStatusCode() {
        response = RestAssured.given(specBuilder.build()).get("/forecast.json");
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        response = RestAssured.given(specBuilder.build()).get("/forecast.json");
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Lviv"));
    }

    @Test
    public void testCountryName() {
        response.then().assertThat()
                .body("location.country", equalTo("Ukraine"));
    }

    @Test
    public void testForecast() {
        dateTime = LocalDate.now(ZoneId.of("Europe/Kiev"));
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        response = RestAssured.given(specBuilder.build()).get("/forecast.json");
        response.then().assertThat()
                .body("forecast.forecastday[0].date", equalTo(date));
    }
}
