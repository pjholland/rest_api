package com.landlords;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.landlords.model.Landlord;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;


public class LandLordTest {

    @Before
    public void init(){
        baseURI = "http://localhost:8080";
    }

    @Test
    public void getLandLords() {

        when().get("/landlords").then().statusCode(200).body("", is(empty()));
    }

    @Test
    public void postLandLord01() {

        Landlord landlord = new Landlord("", "");

        landlord.setFirstName();
        landlord.setLastName();

        String id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(201)
                .body("firstName", is(landlord.getFirstName()))
                .body("lastName", is(landlord.getLastName()))
                .body("trusted", is(false))
                .body("apartments", is(empty()))
                .extract()
                .path("id");
        given()
                .pathParam("id", id)
                .when()
                .get("/landlords/{id}")
                .then()
                .statusCode(200)
                .body("id", is(id))
                .body("firstName", is(landlord.getFirstName()))
                .body("lastName", is(landlord.getLastName()))
                .body("trusted", is(false))
                .body("apartments", is(empty()));

    }

    @Test
    public void postLandLord02() {

        Landlord landlord = new Landlord("", "", true);

        landlord.setFirstName();
        landlord.setLastName();

        String id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(201)
                .body("firstName", is(landlord.getFirstName()))
                .body("lastName", is(landlord.getLastName()))
                .body("trusted", is(true))
                .body("apartments", is(empty()))
                .extract()
                .path("id");
        given()
                .pathParam("id", id)
                .when()
                .get("/landlords/{id}")
                .then()
                .statusCode(200)
                .body("id", is(id))
                .body("firstName", is(landlord.getFirstName()))
                .body("lastName", is(landlord.getLastName()))
                .body("trusted", is(true))
                .body("apartments", is(empty()));

    }

    @Test
    public void postLandLordNegative01() {

        Landlord landlord = new Landlord("", "");

        given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(400)
                .body("message", is("Fields are with validation errors"))
                .body("fieldErrorDTOs[0].fieldName", is("firstName"))
                .body("fieldErrorDTOs[0].fieldError",is("First name can not be empty"))
                .body("fieldErrorDTOs[1].fieldName", is("lastName"))
                .body("fieldErrorDTOs[1].fieldError",is("Last name can not be empty"));
    }

    @Test
    public void putLandlord(){

        Landlord landlord = new Landlord("Mary", "Horse", true);

        String id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        Landlord landLordForUpdate = new Landlord("Mary", "Donkey");

        given()
                .contentType(ContentType.JSON)
                .body(landLordForUpdate)
                .pathParam("id", id)
                .when()
                .put("/landlords/{id}")
                .then()
                .statusCode(200)
                .body("message", is("LandLord with id: "+id+" successfully updated"));

        given()
                .pathParam("id", id)
                .when()
                .get("/landlords/{id}")
                .then()
                .statusCode(200)
                .body("firstName", is(landLordForUpdate.getFirstName()))
                .body("lastName", is(landLordForUpdate.getLastName()))
                .body("trusted", is(false));
    }

    @Test
    public void deleteLandlord01() {

        Landlord landlord = new Landlord("", "");

        landlord.setFirstName();
        landlord.setLastName();

        String id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
        given()
                .pathParam("id", id)
                .when()
                .delete("/landlords/{id}")
                .then()
                .statusCode(200)
                .body("message", is("LandLord with id: "+id+" successfully deleted"));

        given()
                .pathParam("id", id)
                .when()
                .get("/landlords/{id}")
                .then()
                .statusCode(404)
                .body("message", is("There is no landlord with id: " +id));
    }

}
