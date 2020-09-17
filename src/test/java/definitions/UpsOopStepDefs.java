package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomeUps;
import pages.ShippingFromUps;
import pages.ShippingToUps;

import static org.assertj.core.api.Assertions.assertThat;

import static support.TestContext.getData;


import java.util.Map;

public class UpsOopStepDefs {

    Map<String, String> data = getData("ups");

    HomeUps home = new HomeUps();
    ShippingFromUps shippingFrom = new ShippingFromUps();
    ShippingToUps shippingTo = new ShippingToUps();

    @Given("I open {string} page OOP")
    public void iOpenPageOOP(String page) {
        switch (page) {
            case "ups":
                home.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @And("I open Shipping menu OOP")
    public void iOpenShippingMenuOOP() {
        home.shippingTabClick();
    }

    @And("I go to Create a Shipment OOP")
    public void iGoToCreateAShipmentOOP() {
        home.createShipmentClick();
    }

    @When("I fill out origin shipment fields OOP")
    public void iFillOutOriginShipmentFieldsOOP() {
        shippingFrom.fillNameFrom(data.get("name"));
        shippingFrom.fillAddressFrom(data.get("address"));
        shippingFrom.fillZipCityStateFrom(data.get("zip"));
        shippingFrom.fillEmailFrom(data.get("email"));
        shippingFrom.fillPhoneFrom(data.get("phone"));

    }

    @And("I submit the shipment form OOP")
    public void iSubmitTheShipmentFormOOP() {
        shippingFrom.continueButtonClick();
    }

    @Then("I verify origin shipment fields submitted OOP")
    public void iVerifyOriginShipmentFieldsSubmittedOOP() {
        String content = shippingTo.resultBoxContent();
        assertThat(content.contains(data.get("name")));
        assertThat(content.contains(data.get("address")));
        assertThat(content.contains(data.get("zip")));
        assertThat(content.contains(data.get("email")));
        assertThat(content.contains(data.get("phone")));
    }

    @And("I cancel the shipment form OOP")
    public void iCancelTheShipmentFormOOP() {
        shippingTo.cancelButtonClick();
    }

    @Then("I verify shipment form is reset OOP")
    public void iVerifyShipmentFormIsResetOOP() {
        assertThat(shippingFrom.getNameValue().contains(data.get("name"))).isFalse();
        assertThat(shippingFrom.getAddressValue().contains(data.get("address"))).isFalse();
        assertThat(shippingFrom.getZipValue().contains(data.get("zip"))).isFalse();
        assertThat(shippingFrom.getEmailValue().contains(data.get("email"))).isFalse();
        assertThat(shippingFrom.getPhoneValue().contains(data.get("phone"))).isFalse();
    }
}
