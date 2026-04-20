Feature: Datadog Continuous Testing Page - End to End

  Scenario: Full page validation flow
    Given I open the Datadog Continuous Testing page
    Then the page body should be visible
    And the URL should contain "datadoghq.com"
    And the browser tab title should not be empty
    And the H1 heading should not be empty
    And the navigation bar should be visible
