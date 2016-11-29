package openagent.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import openagent.pages.Homepage;
import openagent.pages.FindAgentsListingPage;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;


public class SearchAgentSteps {

    @Steps
    Homepage homepage;
    FindAgentsListingPage findAgentsListingPage;

    @Given("^I am on the Homepage$")
    public void i_am_on_the_Homepage() throws Throwable {
        homepage.openPage();
    }

    @When("^I type '(.*)' in the search inbox$")
    public void i_type_in_the_search_inbox(String postcode) throws Throwable {
        homepage.search_for_agent(postcode);
    }

    @When("^I choose '(.*)' from the dropdown list$")
    public void i_choose_a_from_the_dropdown_list(String suburb) throws Throwable {
        homepage.select_search_agent_autocomplete(suburb);
    }

    @When("^I enter '(.*)' as name,'(.*)' as email and '(.*)' as phone number$")
    public void i_enter_and(String name, String email, String phoneNo) throws Throwable {
        findAgentsListingPage.fill_create_profile_modal_form(name, email, phoneNo);
    }

    @When("^I click the Compare Agent button$")
    public void i_click_the_Compare_Agent_button() throws Throwable {
        findAgentsListingPage.submit_create_profile_modal_form();
    }

    @Then("^I should see how many agents located in '(.*)'$")
    public void i_should_see_how_many_agents_located_in(String suburb) throws Throwable {
        assertTrue(findAgentsListingPage.get_title().contains(suburb));
    }
}
