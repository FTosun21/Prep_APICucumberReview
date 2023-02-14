Feature: Retrieving Profile
#day1- step 1 initial step after creating framework with all package then execute first test
@wip
  Scenario: User able to see all profile
    Given User creates a GET request and able to see all profiles
    Then Verify that status code is 200

#day1- step 2 after this scenario follow step number ***d1s2- 1
# show DevExRequest class as action class
  @wip2
  Scenario: User able to see all profiles second way
    Given User creates a GET request and able to see all profiles second way
    Then Verify that status code is 200

#day1-step 3 new scenario GET request with path parameter
#after create step def and change parameter
  @wip3
  Scenario Outline: GET request with path parameter
    Given User creates a GET request with path "<id>"
    Then Verify that status code is 200
    Then Verify that user info's "<name>" and "<email>" and "<company>" and "<location>"

    Examples:
      | id  | name    | email                | company        | location |
      | 236 | Mike Masters   | etsMntr@eurotech.com | eurotech      | Germany   |
      | 528 | Teacher | eurotech@gmail.com   | Eurotech Study | London   |