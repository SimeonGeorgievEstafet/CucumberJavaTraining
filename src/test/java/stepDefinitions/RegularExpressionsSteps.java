package stepDefinitions;

import helpers.StringHelper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Objects;

public class RegularExpressionsSteps {

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

    @Given("set case sensitivity to {isCaseSensitive}")
    public void setCaseSensitiveTrue(Boolean isCaseSensitive) {
        this.isCaseSensitive = isCaseSensitive;
    }

    @Then("verify the words are equal")
    public void verifyTheWordsAreEqual() {
        String s = StringHelper.areSentencesEqual(firstText, secondText, isCaseSensitive) ? "Words are Equal" : "Words are not Equal";
        System.out.println(s);
    }

    @Given("first word is {word}")
    public void firstWordIs(String firstText) {
        this.firstText = firstText;
    }

    @And("first occurrence of {regexChar} is removed")
    public void removeFirstOccurrence(String removeWord) {
        firstText = firstText.replaceFirst("[" + removeWord + "]", "");
        System.out.println(firstText);
    }

    @When("second word is {word}")
    public void secondWordIs(String secondText) {
        this.secondText = secondText;
    }


    @And("all occurrences of {word} are removed")
    public void allOccurrencesOfAreRemoved(String removeWord) {
        firstText = firstText.replace(removeWord, "");
        System.out.println(firstText);
    }

    @Given("first sentence is {string}")
    public void firstSentenceIs(String sentence) {
        firstText = sentence;
    }

    @When("second sentence is {string}")
    public void secondSentenceIs(String sentence) {
        sentence2 = sentence;
    }

    @Then("verify the sentences are equal")
    public void verifyTheSentencesAreEqual() {
        System.out.println("First sentence is: " + firstText);
        System.out.println("Second sentence is: " + secondText);
        System.out.println((StringHelper.areSentencesEqual(firstText, secondText, isCaseSensitive) ? "Both sentences are equal" : "Both sentences are not equal"));
    }

    @Given("input text")
    public void inputText(String text) {
        this.firstText = text;

    }

    @When("all whitespaces before {regexChar} are removed")
    public void allWhitespacesBeforeAreRemoved(String specialChar) {
        firstText = firstText.replaceAll("\\s+(?=" + specialChar + ")", "");
        System.out.println(firstText);
    }
    @ParameterType("[{}().,?!:\\-]")
    public String regexCharForText(String specialChar) {
//        Character character = specialChar.charAt(0);
        return specialChar;
    }

    @ParameterType("[\\]\\[{}().,?!:\\-a-zA-Z]")
    public String regexChar(String specialChar) {
        char character = specialChar.charAt(0);
        return String.valueOf(Character.isLetter(character) ? character : "\\" + character);
    }

    @And("all consecutive whitespace chars are replaced with a single space")
    public void allConsecutiveWhitespaceCharsAreReplacedWithASingleSpace() {
        firstText = firstText.trim().replaceAll("\\s+", " ");
        System.out.println(firstText);
    }

    @Then("verify the input text word count is equal to {int}")
    public void verifyTheInputTextWordCountIsEqualTo(int wordCount) {
        Assertions.assertEquals(wordCount, StringHelper.getWordsCountFromText(firstText));
    }

    @And("verify the input text char count is equal to {int}")
    public void verifyTheInputTextCharCountIsEqualTo(int charCount) {
        Assertions.assertEquals(charCount, StringHelper.getCharsCount(firstText));
    }
}
