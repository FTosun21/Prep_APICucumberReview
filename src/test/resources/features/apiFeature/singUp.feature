Feature: Sign Up

#day1 step4 -14 after define the step under SingUpStepDef & go to stepDef
  @wip4
  Scenario Outline: DevEx User Register

    Given User creates a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    #Then Verify that status code is 200
    #//***d1s4 - 21 after go to SingUpStepDef
    Then Verify that status code should be 200
    Then Verify that body contains "token"
    #this line later
    #And Compiler gets the token

    Examples:
      | email            | password | name     | google    | facebook | github |
      #| johnyQ@gmail.com | Test1234 | Johny QA | JQ Google | JQ face  | JQ Git |
      | johnyQ0@gmail.com | Test1234 | Johny QA | JQ Google | JQ face  | JQ Git |