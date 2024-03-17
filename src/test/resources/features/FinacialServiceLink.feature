Feature: login for old user


 Scenario: 
    Given open "chrome" browser
    When launch site
    And click on about us link
    And click on careers link
    When I attempt to search all jobs
      When I search for "automation tester" in the search box
    Then search results should display at least one or more of the job
    #Then search results should display at least one or more of “automation tester”
     And close site