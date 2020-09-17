package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult extends Page {

    @FindBy(name="username")
    private WebElement usernameResult;

    @FindBy(name="email")
    private WebElement emailResult;

    @FindBy(name="name")
    private WebElement nameResult;

    @FindBy(name="password")
    private WebElement passwordResult;

    @FindBy(name="agreedToPrivacyPolicy")
    private WebElement agreedToPrivacyPolicyResult;

    @FindBy(name="firstName")
    private WebElement firstNameResult;

    @FindBy(name="lastName")
    private WebElement lastNameResult;

    @FindBy(name="phone")
    private WebElement phoneResult;

    @FindBy(name="dateOfBirth")
    private WebElement dateOfBirthResult;

    @FindBy(name="countryOfOrigin")
    private WebElement countryResult;

    @FindBy(name="gender")
    private WebElement genderResult;

    @FindBy(name="allowedToContact")
    private WebElement allowedToContactResult;

    @FindBy(name="address")
    private WebElement addressResult;

    @FindBy(name="carMake")
    private WebElement carMakeResult;

    @FindBy(name="contactPersonPhone")
    private WebElement contactPersonPhone;

    @FindBy(name="contactPersonName")
    private WebElement contactPersonName;

    @FindBy(name="thirdPartyAgreement")
    private WebElement thirdPartyAgreementResult;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;


    public String usernameValue() {
        return usernameResult.getText();
    }

    public String emailValue() {
        return emailResult.getText();
    }

    public String nameValue() {
        return nameResult.getText();
    }

    public String passwordValue() {
        return passwordResult.getText();
    }

    public String agreedToPrivacyPolicyResultValue() {
        return agreedToPrivacyPolicyResult.getText();
    }

    public String firstNameValue() {
        return firstNameResult.getText();
    }

    public String lastNameValue() {
       return lastNameResult.getText();
    }

    public String phoneValue() {
        return phoneResult.getText();
    }

    public String dateOfBirthValue() {
        return dateOfBirthResult.getText();
    }

    public String countryValue() {
        return countryResult.getText();
    }

    public String genderValue() {
        return genderResult.getText();
    }

    public String allowedToContactValue() {
        return allowedToContactResult.getText();
    }

    public String addressValue() {
        return addressResult.getText();
    }

    public String carValue() {
        return carMakeResult.getText();
    }

    public String contactNameValue() {
        return contactPersonName.getText();
    }

    public String contactPhoneValue() {
        return contactPersonPhone.getText();
    }

    public String thirdPartyAgreementResultValue() {
        return thirdPartyAgreementResult.getText();
    }

    public boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
    }

    public boolean isAllowedToContact() {
        return Boolean.parseBoolean(allowedToContact.getText());
    }



}