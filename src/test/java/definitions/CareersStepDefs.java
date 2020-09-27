package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersHome;
import pages.CareersLogin;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersStepDefs {

    CareersHome home = new CareersHome();
    CareersLogin login = new CareersLogin();
    CareersRecruit recruit = new CareersRecruit();

    @And("I login as {string}")
    public void iLoginAs(String role) {
        Map<String, String> data = getData(role);

        home.loginButtonClick();
        login.fillUsername(data.get("email"))
             .fillPassword(data.get("password"))
             .submit();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        Map<String, String> data = getData(role);
        assertThat(home.getUserName()).isEqualTo(data.get("name"));
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) throws InterruptedException {
        home.recruitButtonClick();
        recruit.closeButtonClick(position);
        Thread.sleep(1000);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position) {
        assertThat(recruit.getAllPositionsText()).doesNotContain(position);
    }
}
