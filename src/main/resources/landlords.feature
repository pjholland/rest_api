@landlords

  Feature: User can access the landlords api

    Background:
      Given I have access to the landlords api

      @landlords
      Scenario: The user is able to get all registered landlord
        Then I can add a new landlord via the api
        And I see the correct 200 status returned