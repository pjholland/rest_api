

Feature: User can access the landlords api

  Background:
    Given I have access to the landlords api

  @landlords
  Scenario: The user is able add a landlord
    When I add a new landlord via the api
    Then the new landlord is added to the system
    And all fields have been aded correcly

  Scenario: The user is able to delete a landlord from the system
    When the user deletes a landlord
    Then landlord record is removed from the system

  Scenario: The user is able to amend a landlord record
    When the user amends a landlord record
    Then the update is visible on the system

  Scenario: The user is able to add a apartment for a landlord
    When the user adds a landlord with an appartment
    Then the apartment and landlord is added to the system


