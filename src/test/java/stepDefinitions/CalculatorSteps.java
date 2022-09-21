package stepDefinitions;

import helpers.Calculator;
import helpers.DifferenceCalculatorHelper;
import helpers.SumCalculatorHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CalculatorSteps {

    int input1;
    int input2;
    Calculator calculator;

    double doubleInput1;
    double doubleInput2;

    @Given("set first int to {int}")
    public void setFirstVariableTo(int firstVariable) {
        input1 = firstVariable;
    }

    @Given("set second int to {int}")
    public void setSecondVariableTo(int secondVariable) {
        input2 = secondVariable;
    }

    @Then("verify int result is: {int}")
    public void verifyResultIs(int result) {
        Assertions.assertEquals(calculator.calculate(input1, input2), result);
    }

    @Given("set Calculator {calculator}")
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @ParameterType("sum|difference")
    public Calculator calculator(String type) {
        return type.equalsIgnoreCase("sum") ? new SumCalculatorHelper() : new DifferenceCalculatorHelper();
    }

    @Given("set first variable to {double}")
    public void setFirstVariableTo(double input) {
        doubleInput1 = input;
    }

    @Given("set second variable to {double}")
    public void setSecondVariableTo(double input) {
        doubleInput2 = input;
    }

    @Then("verify result is: {double}")
    public void verifyResultIs(double result) {
        Assertions.assertEquals(calculator.calculate(doubleInput1, doubleInput2), result);
    }

    @Given("sum up all the numbers in column 1 and 2$")
    public void sumUpAllTheNumbersInColumnAnd(DataTable table) {
        input1 = calculator.calculate(Integer.parseInt(table.column(0).get(1)), Integer.parseInt(table.column(0).get(2)));
        input2 = calculator.calculate(Integer.parseInt(table.column(1).get(1)), Integer.parseInt(table.column(1).get(2)));
    }

    @Then("compare both columns and print result")
    public void compareBothColumnsAndPrintResult() {
        String result = (input1 > input2) ? "First column" : "Second column";
        System.out.println("First column sum is:" + input1);
        System.out.println("Second column sum is:" + input2);
        System.out.println("The bigger column is: " + result);
    }
}
