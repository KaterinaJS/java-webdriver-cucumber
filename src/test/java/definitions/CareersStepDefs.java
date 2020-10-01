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

    // xpath axes
//    String example1 ="//label[@for='loginUsername']/ancestor::div[@class='container']";
//    String example2 ="//label[@for='loginUsername']/following-sibling::input";

    // css sel
//    String example1Xpath = "//*[contains(@class,'fixed-top')]";
//    String example2Css = ".fixed-top";

//    CareersHome home = new CareersHome();
//    CareersLogin login = new CareersLogin();
//    CareersRecruit recruit = new CareersRecruit();

//    @And("I login as {string}")
//    public void iLoginAs(String role) {
//        Map<String, String> data = getData(role);
//
//        home.loginButtonClick();
//        login.fillUsername(data.get("email"))
//             .fillPassword(data.get("password"))
//             .submit();
//    }

    @And("I login as {string}")
    public void iLoginAs(String role) {
        new CareersHome()
                .clickLogin()
                .login(getData(role));
    }

//    @Then("I verify {string} login")
//    public void iVerifyLogin(String role) {
//        Map<String, String> data = getData(role);
//        assertThat(home.getUserName()).isEqualTo(data.get("name"));
//    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        String expectedName = getData(role).get("name");
        String actualName = new CareersHome().getLoggedUserName();
        assertThat(actualName).isEqualTo(expectedName);
    }

//    @When("I remove {string} position")
//    public void iRemovePosition(String position) throws InterruptedException {
//        home.recruitButtonClick();
//        recruit.closeButtonClick(position);
//        Thread.sleep(1000);
//    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) throws InterruptedException {
        new CareersHome()
                .clickRecruit()
                .removePosition(title);
    }

//    @And("I verify {string} position is removed")
//    public void iVerifyPositionIsRemoved(String position) {
//        assertThat(recruit.getAllPositionsText()).doesNotContain(position);
//    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) {
        new CareersRecruit().refresh();
        boolean isVisible = new CareersRecruit().isPositionVisible(title);
        boolean errorsPresent = new CareersRecruit().areErrorsPresent();
        assertThat(errorsPresent).isFalse();
        assertThat(isVisible).isFalse();
    }
}
