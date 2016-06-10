package com.landlords;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import  io.restassured.matcher.RestAssuredMatchers.*;


public class LandLordTest {

    @Test
    public void getLandLords() {

        baseURI = "http://localhost:8080";

        when()
                .get("/landlords")
                .then()
                .statusCode(200)
        .body("", is(empty()));
    }

    @Test
    public void postLandLord01(){


    }
}
