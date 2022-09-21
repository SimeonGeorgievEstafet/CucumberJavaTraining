Feature: Calculator

#  Verify the calculation of numbers
  Rule: Verify the calculation with Sum calculator

    Background: Set Calculator
      Given set Calculator sum

    Scenario: Sum Integers
      Given set first int to 3
      And set second int to 5
      Then verify int result is: 8

    Scenario: Sum Decimals
      Given set first variable to 1.2
      And set second variable to 3.0
      Then verify result is: 5.2


  Rule: Verify the calculation of Decimals
    Background: Set Calculator
      Given set Calculator difference

    Scenario: Difference Integers
      Given set first int to 10
      And set second int to 6
      Then verify int result is: 4

    Scenario:Difference Decimals
      Given set first variable to 7.5
      And set second variable to 2.5
      Then verify result is: 3.8


#    Compare two columns with numbers
  Rule: Compare the two columns after adding the numbers in them
    Background: Set Calculator
      Given set Calculator sum

    Scenario: Add numbers in columns scenario 1
      Given sum up all the numbers in column 1 and 2
        | column 1 | column 2 |
        | 3        | 7        |
        | 9        | 4        |
      Then compare both columns and print result

    Scenario: Add numbers in columns scenario 2
      Given sum up all the numbers in column 1 and 2
        | column 1 | column 2 |
        | 2        | 4        |
        | 5        | 4        |
      Then compare both columns and print result

  Rule: Compare the two columns after subtracting the numbers in them
    Background: Set Calculator
      Given set Calculator difference

    Scenario: Subtract numbers in columns scenario 1
      Given sum up all the numbers in column 1 and 2
        | column 1 | column 2 |
        | 3        | 7        |
        | 9        | 4        |
      Then compare both columns and print result

    Scenario: Subtract numbers in columns scenario 2
      Given sum up all the numbers in column 1 and 2
        | column 1 | column 2 |
        | 3        | 7        |
        | 9        | 4        |
      Then compare both columns and print result

