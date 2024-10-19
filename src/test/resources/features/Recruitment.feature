Feature: Recruitment

  Scenario: User can hire a candidate
    Given the user opens the Orange site
    When the user signs up with a username and password
    And the user adds a new candidate
    And the user manages a candidate
    Then the user sees the candidate's information
