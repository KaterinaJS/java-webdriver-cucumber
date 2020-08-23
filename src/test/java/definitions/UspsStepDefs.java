package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(@href,'postcalc')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        Select countrySelect = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        countrySelect.selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String number) {
        getDriver().findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(number);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String actualCost = getDriver().findElement(By.xpath("//div[@id='cost-0']")).getText();
        assertThat(actualCost.equals(cost));
    }
}