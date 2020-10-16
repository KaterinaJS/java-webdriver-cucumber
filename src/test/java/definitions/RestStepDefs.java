package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.RestClient;


import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {

    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        new RestClient().login(getData(role));
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String type) {
        new RestClient().createPosition(getData(type));
    }
}