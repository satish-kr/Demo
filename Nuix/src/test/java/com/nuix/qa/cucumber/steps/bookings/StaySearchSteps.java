package com.nuix.qa.cucumber.steps.bookings;

import com.nuix.qa.cucumber.steps.NuixBaseSteps;
import com.nuix.qa.pages.bookings.stays.StaysSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StaySearchSteps extends NuixBaseSteps {

    @Then("I input the from location as {} on StaysPage")
    public void iInputTheFromLocation(String location) {
        getWithWait(StaysSearchPage.class).searchQuery(location);
    }

    @And("I click on search button on StaysPage")
    public void iClickOnSearchButtonOnStaysPage() {
        getWithWait(StaysSearchPage.class).clickSearchButton();
    }

    @Then("I verify the search results on StaysPage")
    public void iVerifyTheSearchResultsOnStaysPage() {
        // Validate search
    }
}
