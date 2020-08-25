package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        WebElement searchIcon = getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]/a[@class='menuitem']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(searchIcon).perform();
        getDriver().findElement(By.xpath("//div[@class='repos']//a[text()='" + search.toUpperCase() + "']")).click();

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String number) {
        String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(result.contains(number));
    }

    @When("I select {string} in results")
    public void iSelectInResults(String option) throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//span[text()='" + option + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//a[text()='" + button + " ']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        getDriver().navigate().to("https://reg.usps.com/entreg/LoginAction_input?app=GSS&appURL=https://cns.usps.com/labelInformation.shtml");

        WebElement signInButton = getDriver().findElement(By.xpath("//button[@id='btn-submit']"));
        wait.until(ExpectedConditions.visibilityOf(signInButton));

    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(@href, 'faq')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Search')]")).sendKeys(search);
        getDriver().findElement(By.xpath("//button[contains(@class,'search-button')]")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String search) {
        String resultPage = getDriver().findElement(By.xpath("//div[contains(@class,'forceSearchResultsRegion')]")).getText();
        assertThat(resultPage.contains(search)).isFalse();
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-find']/a[contains(@href,'find-location')]")).click();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String location, String services, String availableServices) {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[@data-value='po']")).click();

        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//li[@id='pickupPo']//a[text()='" + services + "']")).click();

        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[text()='" + availableServices + "'][@data-value='accountable']")).click();

    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);

        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']")));
        stateSelect.selectByValue(state);
        
        getDriver().findElement(By.xpath("//div[contains(@class,'goto-results-btn')]/a")).click();
    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phone) {
        getDriver().findElement(By.xpath("(//div[contains(@class, 'list-item-location')])[1]")).click();
        assertThat(getDriver().findElement(By.xpath("//p[@class='ask-usps']")).getText().contains(phone));
    }
}