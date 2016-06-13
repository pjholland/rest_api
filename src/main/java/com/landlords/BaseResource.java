package com.landlords;


import org.junit.Before;

import static io.restassured.RestAssured.baseURI;

public class BaseResource {

    @Before
    public void accessApi(){
        baseURI = "http://localhost:8080";
    }


}
