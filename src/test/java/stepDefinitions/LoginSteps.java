package stepDefinitions;

import io.cucumber.java.en.*;

public class LoginSteps {
    @Given("open Login page.")
    public void openLoginPage() {
        System.out.println("You are at Login page");
    }

    @When("^I enter Username as \"([^\"]*)\"$")
    public void enterUsername(String username) {
        System.out.println(username);
    }

    @And("^I enter Password as \"([^\"]*)\"$")
    public void enterPassword(String password) {
        System.out.println(password);
    }

    @Then("print success message")
    public void printSuccessMessage() {
        System.out.println("Success message!");
        System.out.println(" ");
    }

    @Then("print Error message")
    public void printErrorMessage() {
        System.out.println("Error message!");
    }

    @But("print some other message")
    public void printSomeOtherMessage() {
        System.out.println("Other message!");
        System.out.println(" ");
    }

}
