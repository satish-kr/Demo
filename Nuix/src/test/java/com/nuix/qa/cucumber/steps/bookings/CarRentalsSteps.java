package com.nuix.qa.cucumber.steps.bookings;

import com.nuix.qa.cucumber.steps.NuixBaseSteps;
import com.nuix.qa.pages.bookings.carrentals.CarRentalsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarRentalsSteps extends NuixBaseSteps {

    @Then("I input the from location as {} on Car Rentals")
    public void iInputTheFromLocation(String location) {
        getWithWait(CarRentalsPage.class).searchQuery(location);
    }


    @Then("I select dates {} to {}")
    public void iSeletDates(String fromDate, String toDate) {
        // Should Fetch the actual dates in given format from the Model and system date and input
        // Skipping for demo

    }

    @Then("I verify the search results on carrentals page")
    public void iVerifyTheSearchResultsOnCarrentalsPage() {
        // Validate search results
    }

    @When("I click the search button on Car Rentals")
    public void iClickOnSearchButton() {
        getWithWait(CarRentalsPage.class).clickSearchButton();
    }

    @And("I select dates the first search sugeestion")
    public void iSelectDatesTheFirstSearchSugeestion() {
        getWithWait(CarRentalsPage.class).clickFirstSearchSuggestions();
    }
}
