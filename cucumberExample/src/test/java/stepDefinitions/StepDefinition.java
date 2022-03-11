package stepDefinitions;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {


	@Given("some other precondition")
	public void some_other_precondition() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("I complete action {string}")
	public void i_complete_action(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(string);
	}

	@When("some other action")
	public void some_other_action() {
	    // Write code here that turns the phrase above into concrete actions
	   	}

	@When("yet another action")
	public void yet_another_action() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Given("^I want to write a step with (.+)$")
	public void i_want_to_write_a_step_with_name1(String name1) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println(name1);
	}

	 @When("^I check for the (.+) in step$")
	public void i_check_for_the_in_step(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(int1);
	}

	 @Then("^I verify the (.+) in step$")
	public void i_verify_the_success_in_step(String val) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println(val);
	}

	
	
	@Given("Login to the url {string}")
	public void login_to_the_url(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(string);
	}

	@When("Verify the title of page")
	public void verify_the_title_of_page() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	

	@Then("Verify the details")
	public void verify_the_details(io.cucumber.datatable.DataTable dataTable) {
	   
	   for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
			System.out.println(data.get("fname")); 
			System.out.println(data.get("lname")); 
			System.out.println(data.get("email")); 
			System.out.println(data.get("contact")); 
			System.out.println(data.get("country")); 
	   }
	   
	  List<List<String>> ls= dataTable.asLists(String.class);
	  System.out.println("1st element :"+ls.get(0).get(0));
	  int i=0;
	  while(i<ls.size()) {
		  System.out.println("value :"+ls.get(1).get(i));
		  i++;
	  }
	  
	}

	@Then("^Enter from City (.+)$")
   public void enter_from_city_from_city(String fromCity) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(fromCity);
	}

	@Then ("^To City (.+)$")	
	public void to_city_to_city(String toCity) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(toCity);
	}

	@Then("Click on Search button")
	public void click_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
}
