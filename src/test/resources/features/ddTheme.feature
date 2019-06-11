
@tag
Feature: Theme setting to drak theme


  @AC5
  Scenario: Theme Settings
    Given Guest user on home page
    When user load the settings menu
    And selects theme menu item
    And select the theme type
    And select the saveExit 
    Then the theme color is applied
    


