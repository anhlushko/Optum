@wip
Feature: Registration form to Optum Store

  Scenario: Registration form
    Given user is on optum page
    When  user click on Sign in
    And user click on Individuals and families
    Then click register under Optum Store
    When  enter first name
    And enter last name
    And enter valid email
    Then create a valid password
    And enter valid phone number
    And click on radio button I agree to Optum Store's Terms of Service and Privacy Policy
    Then user click on Continue button



