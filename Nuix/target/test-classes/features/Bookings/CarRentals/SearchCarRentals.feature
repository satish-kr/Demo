@carRental

  Feature: Car rental search

    Scenario: Search for a car rentals with specified date
      Given I am on the Bookings Car rentals Page
      Then I input the from location as Gold coast on Car Rentals
      And I select dates the first search sugeestion
      Then I select dates SYSTEMDATE+1 to SYSTEMDATE+2
      When I click the search button on Car Rentals
      Then I verify the search results on carrentals page

