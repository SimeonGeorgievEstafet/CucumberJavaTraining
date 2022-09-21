Feature: Login functionality

  Rule: Login with Background feature
    Background:
      * open Login page.

    Scenario: Login with user.
      When I enter Username as "user_1@gmail.com"
      And I enter Password as "12345"
      Then print success message
      But print some other message


    Scenario Outline: Login with different users.
      When I enter Username as "<username>"
      And I enter Password as "<password>"
      Then print success message
      Examples:
        | username         | password  |
        | user_1@gmail.com | 12345     |
        | user_2@yahoo.com | SECRET123 |
        | user_3@abv.bg    | 0000000   |


  Rule: Verify Login without Background feature

    Scenario Outline: Login with different users empty Username/Password.
    """
        You can use this to put comments in the Cucumber Scenario
    """
      Given open Login page.
      When I enter Username as "<username>"
      And I enter Password as "<password>"
      Then print Error message
      Examples:
        | username         | password |
        |                  | 12345    |
        | user_2@yahoo.com |          |
        |                  |          |

