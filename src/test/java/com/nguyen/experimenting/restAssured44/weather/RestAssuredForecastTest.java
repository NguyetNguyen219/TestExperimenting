package com.nguyen.experimenting.restAssured44.weather;

import com.nguyen.experimenting.restAssured44.RestAssuredBaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredForecastTest extends RestAssuredBaseTest {

    private String key = "8c89e95bcbb148b1bea32255212410";
    private Response response = null;
    private LocalDate dateTime = null;

    @BeforeMethod
    public void setupGet() {
        //building the request headers
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder
                .setBaseUri("http://api.weatherapi.com/v1")
                .addParam("key", key)
                .addParam("q", "Lviv")
                .addParam("days", "1");

        dateTime = LocalDate.now(ZoneId.of("Europe/Kiev"));

        //requesting and saving the response
        response = RestAssured.given(specBuilder.build())
                .get("/forecast.json");
    }

    @Test
    public void testStatusCode() {
        Assert.assertEquals(response.statusCode(), 200); //OK
    }

    @Test
    public void testLocationName() {
        response.then().assertThat().log().all()
                .body("location.name", equalTo("Lviv"));
    }

    @Test
    public void testCountryName() {
        response.then().assertThat()
                .body("location.country", equalTo("Ukraine"));
    }

    @Test
    public void testTimeZoneId() {
        response.then().assertThat()
                .body("location.tz_id", equalTo("Europe/Kiev"));
    }

    @Test
    public void testForecast() {
        String date = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        response.then().assertThat()
                .body("forecast.forecastday[0].date", equalTo(date));
    }
}
