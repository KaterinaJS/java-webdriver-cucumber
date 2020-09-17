package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class ShippingFromUps {

    public ShippingFromUps() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id="origincountry")
    private WebElement countryFrom;

    @FindBy(id="originname")
    private WebElement nameFrom;

    @FindBy(id="originaddress1")
    private WebElement addressFrom;

    @FindBy(id="originpostal")
    private WebElement zipFrom;

    @FindBy(id="origincity")
    private WebElement cityFrom;

    @FindBy(id="originstate")
    private WebElement stateFrom;

    @FindBy(id="originemail")
    private WebElement emailFrom;

    @FindBy(id="originphone")
    private WebElement phoneFrom;

    @FindBy(id="nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;


    public void fillNameFrom(String value) {
        nameFrom.sendKeys(value);
    }

    public void fillAddressFrom(String value) {
        addressFrom.sendKeys(value);
    }

    public void fillZipCityStateFrom(String value) {
        zipFrom.sendKeys(value);
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(cityFrom, "value"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(stateFrom, "value"));
    }

    public void fillEmailFrom(String value) {
        emailFrom.sendKeys(value);
    }

    public void fillPhoneFrom(String value) {
        phoneFrom.sendKeys(value);
    }

    public void continueButtonClick() {
        getExecutor().executeScript("arguments[0].click();", continueButton);
    }

    public String getNameValue() {
        return nameFrom.getText();
    }

    public String getAddressValue() {
        return addressFrom.getText();
    }

    public String getZipValue() {
        return zipFrom.getText();
    }

    public String getEmailValue() {
        return emailFrom.getText();
    }

    public String getPhoneValue() {
        return phoneFrom.getText();
    }
}
