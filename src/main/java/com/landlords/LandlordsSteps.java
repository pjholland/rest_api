package com.landlords;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;

public class LandlordsSteps extends LandLordTest {

    private LandLordTest landLordTest;

    @Given("^I have access to the landlords api$")
    public void i_have_access_to_the_landlords_api() throws Throwable {
        landLordTest = new LandLordTest();
        landLordTest.init();
    }

    @Then("^I can retrieve all landlord information$")
    public void i_can_retrive_all_landlord_information() throws Throwable {

    }

    @Then("^I can add a new landlord via the api$")
    public void iCanAddNewLandlordViaTheApi() throws Throwable {
        landLordTest.postLandLord01();
    }

    @And("^I see the correct (\\d+) status returned$")
    public void iSeeTheCorrectStatusReturned(int status) throws Throwable {

    }
}
