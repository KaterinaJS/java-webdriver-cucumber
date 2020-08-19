package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[contains(@class,'nav-first-element')]")).click();
        getDriver().findElement(By.xpath("//img[contains(@src, 'find_zip')]")).click();
        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        String stateXpath = "//select[@id='tState']//option[@value='" + state + "']";
        getDriver().findElement(By.xpath(stateXpath)).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String resultForm = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
        assertThat(resultForm.contains(zip));
    }

}