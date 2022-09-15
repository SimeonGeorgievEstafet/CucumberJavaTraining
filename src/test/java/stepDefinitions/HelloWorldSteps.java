package stepDefinitions;

import io.cucumber.java.en.Given;

public class HelloWorldSteps {
    @Given("print in console")
    public void helloWorld() {
        System.out.println("Hello World!");
    }
}
