package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class UpsStepDefs {

    Map<String, String> data = getData("ups");

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//ul[@class='ups-menu_links']//a[contains(@href, 'ship?loc')]")).click();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='origincountry']")));
        countrySelect.selectByVisibleText("United States");

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(data.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(data.get("address"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(data.get("zip"));

        WebElement city = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        WebElement state = getDriver().findElement(By.xpath("//select[@id='originstate']"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(city, "value"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(state, "value"));

        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(data.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(data.get("phone"));
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        WebElement continueButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        getExecutor().executeScript("arguments[0].click();", continueButton);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String result = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        assertThat(result.contains(data.get("name")));
        assertThat(result.contains(data.get("address")));
        assertThat(result.contains(data.get("zip")));
        assertThat(result.contains(data.get("email")));
        assertThat(result.contains(data.get("phone")));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement cancelButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        getExecutor().executeScript("arguments[0].click();", cancelButton);

        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText().contains(data.get("name"))).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText().contains(data.get("address"))).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText().contains(data.get("zip"))).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getText().contains(data.get("email"))).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getText().contains(data.get("phone"))).isFalse();
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(data.get("nameToSend"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(data.get("addressToSend"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(data.get("zipToSend"));

        WebElement cityTo = getDriver().findElement(By.xpath("//input[@id='destinationcity']"));
        WebElement stateTo = getDriver().findElement(By.xpath("//select[@id='destinationstate']"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(cityTo, "value"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(stateTo, "value"));
    }


    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        getDriver().findElement(By.xpath("//div[contains(@class,'shipByWeight')]")).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")));

        Select packageType = new Select(getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")));
        packageType.selectByVisibleText("UPS Express Box - Small");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nbsPackagePackageWeightField0']")));

        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1");
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")).isDisplayed());
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        WebElement lowestButton = getDriver().findElement(By.xpath("//input[@id='nbsServiceTileServiceRadio7']"));
        getExecutor().executeScript("arguments[0].click();", lowestButton);
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("Book");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='nbsSaturdayDeliveryOptionBaseOptionSwitch']")));

        WebElement saturdayDelivery = getDriver().findElement(By.xpath("//saturday-delivery-option[@class='ng-star-inserted']//label[contains(@class,'section-checkbox-label')]"));
        getExecutor().executeScript("arguments[0].click();", saturdayDelivery);

    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() throws InterruptedException {
        String totalSaturdayOption = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
        System.out.println("saturday " + totalSaturdayOption);

        WebElement backButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationBackButton']"));
        getExecutor().executeScript("arguments[0].click();", backButton);

        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//spinner[@class='ng-tns-c2-1']//img")));

        String totalOption = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']")).getText();
        System.out.println("total " + totalOption);

        assertThat(totalOption.equals(totalSaturdayOption)).isFalse();

        WebElement continueButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        getExecutor().executeScript("arguments[0].click();", continueButton);

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nbsShipmentDescription']")));
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("Book");

        Thread.sleep(3000);

    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        getWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tile-4']//label[@class='ups-tile_button_content']")));
        getDriver().findElement(By.xpath("//div[@id='tile-4']//label[@class='ups-tile_button_content']")).click();
    }

    @And("I continue the shipment form")
    public void iContinueTheShipmentForm() {
        WebElement continueButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
        getExecutor().executeScript("arguments[0].click();", continueButton);

    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        String resultForm = getDriver().findElement(By.xpath("//main[@id='ups-main']")).getText();

        assertThat(resultForm.contains(data.get("name")));
        assertThat(resultForm.contains(data.get("address")));
        assertThat(resultForm.contains(data.get("zip")));
        assertThat(resultForm.contains(data.get("email")));
        assertThat(resultForm.contains(data.get("phone")));

        assertThat(resultForm.contains(data.get("nameToSend")));
        assertThat(resultForm.contains(data.get("addressToSend")));
        assertThat(resultForm.contains(data.get("zipToSend")));

        assertThat(resultForm.contains("Express Box - Small"));
        assertThat(resultForm.contains("1 lbs"));

        assertThat(resultForm.contains("Saturday Delivery"));

        assertThat(resultForm.contains("PayPal"));
    }
}
