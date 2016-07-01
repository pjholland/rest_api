package com.landlords;


import static io.restassured.RestAssured.baseURI;

public class HelperMethods {

    public void init(){
        baseURI = "http://localhost:8080";
    }
}
