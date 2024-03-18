@smoketest
Feature: Searching for jobs on LexisNexis website

  Scenario: Search for "automation tester" jobs
    Given User open "chrome" browser
    And User opens the LexisNexis Risk website
    And navigates to About us page
    And click on careers link
    And User clicks on Search all jobs
    When User searches for "automation tester"
    Then At least one or more search result is displayed
    And close site
