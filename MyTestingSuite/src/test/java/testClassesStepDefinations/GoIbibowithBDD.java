package testClassesStepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;



public class GoIbibowithBDD {

    @Given("^Weddriver is initialized$")
    public void weddriver_is_initialized() throws Throwable {
        System.out.println("Weddriver is initialized");
    }

    @When("^User tries to open the Go Ibibo Homepage$")
    public void user_tries_to_open_the_go_ibibo_homepage() throws Throwable {
        System.out.println("User tries to open the Go Ibibo Homepage");
    }

    @Then("^Go Ibibo Homepage opens up$")
    public void go_ibibo_homepage_opens_up() throws Throwable {
        System.out.println("Go Ibibo Homepage opens up");
    }

}