package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getActions;
import static support.TestContext.getData;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                form.open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
//        form.agreeWithPrivacyPolicy();
        form.checkWithPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat(result.usernameValue().equals(user.get("username"))).isTrue();
        assertThat(result.emailValue().equals(user.get("email"))).isTrue();
        assertThat(result.nameValue().equals(user.get("name"))).isTrue();
        assertThat(result.passwordValue().contains(user.get("password"))).isFalse();
        assertThat(result.passwordValue().equals("[entered]")).isTrue();
//        assertThat(result.agreedToPrivacyPolicyResultValue().equals("true")).isTrue();
        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
        assertThat(result.firstNameValue().equals(user.get("firstName"))).isTrue();
        assertThat(result.lastNameValue().equals(user.get("lastName"))).isTrue();
    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillPhone("1234567890");
        form.fillDateOfBirth("8", "1990", "14");
        form.fillCountry("Canada");
        form.clickGender();
        form.clickAllowedToContact();
        form.fillAddress("1900 First st., Palo Alto, CA");
        form.fillCarMake("Toyota");
        form.clickThirdPartyButton();
        form.fillContactInfo(user.get("contactPersonName"), user.get("contactPersonPhone"));
    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);

        assertThat(result.phoneValue().equals("1234567890")).isTrue();
        assertThat(result.dateOfBirthValue().equals("09/14/1990")).isTrue();
        assertThat(result.countryValue().equals("Canada")).isTrue();
        assertThat(result.genderValue().equals("male")).isTrue();
        assertThat(result.allowedToContactValue().equals("true")).isTrue();
        assertThat(result.addressValue().equals("1900 First st., Palo Alto, CA")).isTrue();
        assertThat(result.carValue().equals("Toyota")).isTrue();
        assertThat(result.thirdPartyAgreementResultValue().equals("accepted")).isTrue();

        assertThat(result.contactNameValue()).contains(user.get("contactPersonName"));
        assertThat(result.contactPhoneValue()).contains(user.get("contactPersonPhone"));

    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String error) {
        switch (field) {
            case "username":
                assertThat(form.usernameErrorValue().equals(error)).isTrue();
                break;
            case "email":
                assertThat(form.emailErrorValue().equals(error)).isTrue();
                break;
            case "password":
                assertThat(form.passwordErrorValue().equals(error)).isTrue();
                break;
            case "confirmPassword":
                assertThat(form.confirmPasswordErrorValue().equals(error)).isTrue();
                break;
            case "name":
                assertThat(form.nameErrorValue().equals(error)).isTrue();
                break;
            case "agreedToPrivacyPolicy":
                assertThat(form.agreedToPrivacyPolicyErrorValue().equals(error)).isTrue();
                break;
            default:
                throw new RuntimeException("Unknown field: " + field);
        }
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String text) {
        switch (field) {
            case "username":
                form.fillUsername(text);
                break;
            case "email":
                form.fillEmail(text);
                break;
            case "password":
                form.fillPassword(text);
                break;
            case "confirmPassword":
                form.fillConfirmPassword(text);
                break;
            default:
                throw new RuntimeException("Unknown field: " + field);
        }
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String errorField) {
        switch (errorField) {
            case "username":
                assertThat(form.usernameErrorValue().isEmpty()).isTrue();
                break;
            case "email":
                assertThat(form.emailErrorValue().isEmpty()).isTrue();
                break;
            case "password":
                assertThat(form.passwordErrorValue().isEmpty()).isTrue();
                break;
            case "confirmPassword":
                assertThat(form.confirmPasswordErrorValue().isEmpty()).isTrue();
                break;
            default:
                throw new RuntimeException("Unknown field: " + errorField);
        }

        assertThat(form.isErrorFieldDisplayed(errorField)).isFalse();
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        assertThat(form.getName()).isEqualTo(value);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillFullName(firstName,middleName,lastName);
    }
}