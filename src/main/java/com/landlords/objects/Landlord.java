package com.landlords.objects;

import io.codearte.jfairy.Fairy;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class Landlord {

    private String  firstName;
    private String  lastName;
    private Boolean trusted;
    private String  status;
    private String  id;

    public Landlord(){
    }

    public  Landlord(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public  Landlord(String firstName, String lastName, Boolean trusted){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.trusted   = trusted;
    }


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        Fairy fairy = Fairy.create();
        this.firstName = fairy.person().firstName();
    }

    public  String getLastName(){
        return lastName;
    }

    public void setLastName(){
        Fairy fairy = Fairy.create();
        this.lastName = fairy.person().firstName();
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void  setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    public String getStatus(){
        return status;
    }


    public void createLandlord() {

        Landlord landlord = new Landlord("", "", true);

        landlord.setFirstName();
        landlord.setLastName();

        id = given()
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

    public void verifyLandlordCreateDetails(){
        expect().
                body("landlord.id", equalTo(id)).body("landlord.firstName", is(getFirstName()));

    }

    public void deleteLandlord(){

        Landlord landlord = new Landlord("", "");

        landlord.setFirstName();
        landlord.setLastName();

        id = given()
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
                .statusCode(404);
              //  .body("message", is("There is no landlord with id: " +id));
    }

    public void amendLandlord(){

        Landlord landlord = new Landlord("", "", true);

        landlord.setFirstName();
        landlord.setLastName();

        id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        Landlord landLordForUpdate = new Landlord("", "", false);

        landLordForUpdate.setFirstName();
        landLordForUpdate.setLastName();

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

    public void postSingleLandLord(){


        Landlord landlord = new Landlord("Steven", "Fry");

     id = given()
                .contentType(ContentType.JSON)
                .body(landlord)
                .when()
                .post("/landlords")
                .then().statusCode(201)
                .extract()
                .path("id");








    }



}



