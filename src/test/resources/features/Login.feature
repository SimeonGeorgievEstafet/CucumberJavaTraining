Feature: Login2 functionality

  Scenario Outline: Login with different users.
    Given open Login page.
    When I enter Username as "<username>" and Password as "<password>"
    Then print success message
    Examples:
      | username         | password  |
      | user_1@gmail.com | 12345     |
      | user_2@yahoo.com | SECRET123 |
      | user_3@abv.bg    | 0000000   |

  Scenario Outline: Login with different users.
    Given open Login page.
    When I enter Username as "<username>" and Password as "<password>"
    Then print Error message
    Examples:
      | username         | password |
      |                  | 12345    |
      | user_2@yahoo.com |          |
      |                  |          |