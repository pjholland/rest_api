package com.landlords;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class LandlordsSteps extends BaseResource {



    @Given("^I have access to the landlords api$")
    public void i_have_access_to_the_landlords_api() throws Throwable {
        BaseResource baseResource = new BaseResource();
        baseResource.accessApi();
    }

    @Then("^I can retrieve all landlord information$")
    public void i_can_retrive_all_landlord_information() throws Throwable {


    }




}
