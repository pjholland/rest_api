package com.landlords.steps;

import com.landlords.HelperMethods;
import com.landlords.junit.LandLordTest;
import com.landlords.objects.Apartments;
import com.landlords.objects.Landlord;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LandlordsSteps extends LandLordTest {

    private Landlord landlord;
    private Apartments apartment;
    private HelperMethods helper;


    @Given("^I have access to the landlords api$")
    public void i_have_access_to_the_landlords_api() throws Throwable {
        landlord = new Landlord();
        helper = new HelperMethods();
        helper.init();
    }

    @Then("^I add a new landlord via the api$")
    public void iCanAddNewLandlordViaTheApi() throws Throwable {
        landlord.createLandlord();
    }

    @Then("^the new landlord is added to the system$")
    public void the_new_landlord_is_added_to_the_system() throws Throwable {
        landlord.verifyLandlordCreateDetails();
    }

    @And("^all fields have been aded correcly$")
    public void allFieldsHaveBeenAdedCorrecly() throws Throwable {

    }

    @When("^the user deletes a landlord$")
    public void theUserDeletesALandlord() throws Throwable {
        landlord.deleteLandlord();
    }

    @Then("^landlord record is removed from the system$")
    public void landlordRecordIsRemovedFromTheSystem() throws Throwable {

    }

    @When("^the user amends a landlord record$")
    public void theUserAmendsALandlordRecord() throws Throwable {
        landlord.amendLandlord();

    }

    @Then("^the update is visible on the system$")
    public void theUpdateIsVisibleOnTheSystem() throws Throwable {

    }

    @When("^the user adds a landlord with an appartment$")
    public void theUserAddsALandlordWithAnAppartment() throws Throwable {
        landlord.postSingleLandLord();
        apartment.postApartments();
    }

    @Then("^the apartment and landlord is added to the system$")
    public void theApartmentAndLandlordIsAddedToTheSystem() throws Throwable {

    }
}
