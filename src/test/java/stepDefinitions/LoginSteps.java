package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("open Login page.")
    public void openLoginPage() {
        System.out.println("You are at Login page");
    }

    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void enterUsernameAndPassword(String arg1, String arg2) {
        System.out.println(arg1);
        System.out.println(arg2);
    }

    @Then("print success message")
    public void printSuccessMessage() {
        System.out.println("Success message!");
        System.out.println(" ");
    }

    @Then("print Error message")
    public void printErrorMessage() {
        System.out.println("Error message!");
        System.out.println(" ");
    }
}
