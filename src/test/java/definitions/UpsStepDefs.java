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

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Administrator");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("94022");

        WebElement city = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        WebElement state = getDriver().findElement(By.xpath("//select[@id='originstate']"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(city, "value"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(state, "value"));

        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("mail@example.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890");
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        WebElement continueButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        getExecutor().executeScript("arguments[0].click();", continueButton);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String result = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        assertThat(result.contains("Administrator"));
        assertThat(result.contains("4970 El Camino Real"));
        assertThat(result.contains("94022"));
        assertThat(result.contains("mail@example.com"));
        assertThat(result.contains("1234567890"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement cancelButton = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        getExecutor().executeScript("arguments[0].click();", cancelButton);

        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText().contains("Administrator")).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText().contains("4970 El Camino Real")).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText().contains("94022")).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getText().contains("mail@example.com")).isFalse();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getText().contains("1234567890")).isFalse();
    }
}
