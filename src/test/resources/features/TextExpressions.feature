Feature: Text Expressions functionality

  #  Words
  Rule: Verify Words without case sensitivity
    Background:
      Given set Case sensitive false

    Scenario: Verify equal words 1
      Given The first word is Cucumber
      And The second word is cucumber
      Then I verify words are equal


  Rule: Verify Words with case sensitivity
    Background:
      Given set Case sensitive true

    Scenario: Verify equal words 2
      Given The first word is Cucumber
      And The second word is cucumber
      Then I verify words are equal


  Rule: RegEx words
    Background:
      Given set Case sensitive true

    Scenario: Remove letters with RegEx
      Given The first word is Cucumberss11
      And The second word is cucumbers
      When Remove letter "s"
      And Remove letter "1"
      Then I verify words are equal


  #  Sentences
  Rule: Verify Sentences without case sensitivity
    Background:
      Given set Case sensitive false

    Scenario: Verify equal Sentences
      Given The first sentence is "I set the first sentence to Cucumber is amazing!"
      And The second sentence is "I set the second sentence to cucumber is amazing!"
      Then I verify sentences are equal

    Scenario: Verify equal Sentences 2
      Given The first sentence is "Cucumber is amazing!"
      Given The second sentence is "cucumber is amazing!"
      Then I verify sentences are equal


  Rule: Verify Sentences with case sensitivity
    Background:
      Given set Case sensitive true

    Scenario: Verify equal Sentences 3
      Given The first sentence is "Cucumber is amazing!"
      Given The second sentence is "cucumber is amazing!"
      Then I verify sentences are equal



#    Word and char count

  Rule: Verify Sentences with case sensitivity
    Background:
      Given set Case sensitive true

    Scenario: Verify char and word count
      Given I pass the following first text:
     """
          Lorem ipsum dolor sit amet  ,   consectetur adipiscing elit  , sed do    eiusmod tempor incididunt ut labore et    dolore magna aliqua .
          Ut enim ad minim veniam ? Quis nostrud exercitation  ullamco laboris nisi ut aliquip ex ea commodo consequat .


          Duis aute irure dolor in reprehenderit in  voluptate  -  velit esse   cillum   dolore eu fugiat nulla pariatur ?
          Excepteur sint  occaecat cupidatat non  proident, sunt in culpa qui officia deserunt mollit anim id est laborum !
      """
      Given I get the word (or the char) count
      Then verify the word count is equal to 114
      Then verify the char count is equal to 496


    Scenario: Remove double white spaces
      Given I pass the following first text: "I am  testing whitespaces - is  the count  correct?"
      When remove special char -
      When remove double white spaces
      Given I get the word (or the char) count
      Then verify the word count is equal to 8
      Then verify the char count is equal to 47


  Rule: Remove word from sentence
    Background:
      Given set Case sensitive false

    Scenario: Remove chars from sentence
      Given I pass the following first text: "I am testing with RegEx ((it’s working??!!!)"
      When remove one "("
      When remove all occurrences "?"
      Given I pass the following second text: "I am testing with regex (it’s working!!!)"
      Then verify both sentences are the same





