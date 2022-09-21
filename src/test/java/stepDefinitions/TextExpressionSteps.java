package stepDefinitions;

import helpers.StringHelper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class TextExpressionSteps {

    Boolean isCaseSensitive;
    String word1;
    String word2;
    String sentence1;
    String sentence2;
    Boolean result;
    String firstText;
    String secondText;
    int wordCount;
    int charCount;


    @ParameterType("true|false")
    public Boolean isCaseSensitive(String type) {
        return (Objects.equals(type, "true")) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Given("set Case sensitive {isCaseSensitive}")
    public void setCaseSensitiveTrue(Boolean isCaseSensitive) {
        this.isCaseSensitive = isCaseSensitive;
    }

    @Given("The first word is {word}")
    public void theFirstWord(String word) {
        word1 = word;
    }

    @Given("The second word is {word}")
    public void theSecondWord(String word) {
        word2 = word;
    }

    @Then("I verify words are equal")
    public void iVerifyWordsAreEqual() {
        result = StringHelper.areWordsEqual(word1, word2, isCaseSensitive);
        if (result) {
            System.out.println("Words are Equal");
        } else {
            System.out.println("Words are not Equal");
        }
    }

    @Given("The first sentence is {string}")
    public void theFirstSentenceIs(String sentence) {
        sentence1 = sentence;
    }

    @Given("The second sentence is {string}")
    public void theSecondSentenceIs(String sentence) {
        sentence2 = sentence;
    }

    @Then("I verify sentences are equal")
    public void iVerifySentencesAreEqual() {
        System.out.println((StringHelper.areSentencesEqual(sentence1, sentence2, isCaseSensitive) ? "Sentences are Equal" : "Sentences are not Equal"));

    }

    @Given("I pass the following first text: {string}")
    public void iPassTheFollowingFirstText(String text) {
        this.firstText = text;
    }

    @Given("I pass the following second text: {string}")
    public void iPassTheFollowingSecondText(String text) {
        this.secondText = text;
    }

    @Given("I get the word \\(or the char) count")
    public void iGetTheWordOrTheCharCount() {
        wordCount = StringHelper.getWordsCountFromText(firstText);
        System.out.println("Word count is: " + wordCount);
        charCount = StringHelper.getCharsCount(firstText);
        System.out.println("Char count is: " + charCount);
    }

    @Then("verify the word count is equal to {int}")
    public void verifyTheCountIsEqualTo(int wordCount) {
        if (this.wordCount == wordCount) {
            System.out.println("Word count is correct");
        } else {
            System.out.println("Word count is not correct");
        }
    }

    @Then("verify the char count is equal to {int}")
    public void verifyTheCharCountIsEqualTo(int charCount) {
        if (this.charCount == charCount) {
            System.out.println("Char count is correct");
        } else {
            System.out.println("Char count is not correct");
        }

    }

    @When("Remove letter {string}")
    public void removeChar(String charToRemove) {
        word1 = word1.replace(charToRemove, "");
    }

    @When("remove one {string}")
    public void removeOne(String removeWord) {
        firstText = firstText.replaceFirst("[" + removeWord + "]", "");
        System.out.println(firstText);
    }

    @When("remove all occurrences {string}")
    public void removeAll(String removeWord) {
        firstText = firstText.replace(removeWord, "");
        System.out.println(firstText);

    }

    @Then("verify both sentences are the same")
    public void verifyBothSentencesAreTheSame() {
        System.out.println("First sentence is: " + firstText);
        System.out.println("Second sentence is: " + secondText);
        System.out.println((StringHelper.areSentencesEqual(firstText, secondText, isCaseSensitive) ? "Both sentences are equal" : "Both sentences are not equal"));
    }

    @When("remove special char {regexChar}")
    public void removeSpecialChar(String specialChar) {
        firstText = firstText.replace(" " + specialChar, specialChar);
        System.out.println(firstText);
    }

    @ParameterType("[).,\\-?!:]")
    public String regexChar(String specialChar) {
        return specialChar;
    }

    @When("remove double white spaces")
    public void removeDoubleWhiteSpaces() {
        firstText = firstText.replace("  ", " ");
        System.out.println(firstText);

    }
}
