@stay_search
  Feature: Search for hotel rooms

    Scenario: Search for hotel stay for a specific date
      Given I am on the Bookings Stays Page
      When I input the from location as Gold coast on StaysPage
      And I select dates SYSTEMDATE+1 to SYSTEMDATE+2
      And I click on search button on StaysPage
      Then I verify the search results on StaysPage