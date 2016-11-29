Feature: Search

  @searchFromHeaderArea
  Scenario: search agents using the input field within the header area
    Given I am on the Homepage
    When I type '2000' in the search inbox
    And I choose 'Haymarket' from the dropdown list
    When I enter 'Test' as name,'hhhhh@test.com' as email and '0410000000' as phone number
    And I click the Compare Agent button
    Then I should see how many agents located in 'Haymarket'