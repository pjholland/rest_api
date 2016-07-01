package com.landlords.objects;

import java.util.Random;
import io.codearte.jfairy.Fairy;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

public class Apartments {

    private String id;
    private String address;
    private String features;
    private int price;
    private int square;
    private boolean active;

//    private String [] randomAddress = {"London, Bond Street", "Manchester, Grove Street", "Berlin, Halt Stauser", "Sydney, Harbour Road"};
//       Random random = new Random();
//       int index = random.nextInt(randomAddress.length);
    String apartmentId = null;
    public Apartments(){

    }

    public Apartments(String address, int price, int square){
        this.address = address;
        this.price = price;
        this.square = square;

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String  getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getFeatures(){
        return features;
    }

    public void setFeature(String features){
        this.features = features;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSquare(){
        return square;
    }

    public void setSquare(int square){
        this.square = square;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }


    public void postApartments(){

        Apartments apartment = new Apartments("10 Downing Str", 1000, 25);

        apartmentId = given()
                .contentType(ContentType.JSON)
                .body(apartment)
                .pathParam("id", id)
                .when()
                .post("/landlords/{id}/apartments")
                .then()
                .statusCode(201)
                .body("address", is(apartment.getAddress()))
                .body("price", is(1000f))
                .body("square", is(apartment.getSquare()))
                .body("features", is(empty()))
                .body("active", is(apartment.isActive()))
                .extract()
                .path("id");





    }






}
