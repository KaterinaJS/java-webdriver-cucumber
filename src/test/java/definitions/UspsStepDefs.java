package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
//        wait.until(driver -> resultForm.getText().length() > 0);
//        assertThat(resultForm.getText()).contains(zip);
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
//        WebElement searchIcon = getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]/a[@class='menuitem']"));
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(searchIcon).perform();
//        getDriver().findElement(By.xpath("//div[@class='repos']//a[text()='" + search.toUpperCase() + "']")).click();

        WebElement searchMenu = getDriver().findElement(By.xpath("//li[contains(@class, 'nav-search')]"));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        new Actions(getDriver())
                .moveToElement(searchMenu)
                .sendKeys(searchInput, search)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']")).click();
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String number) {
//        String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
//        assertThat(result.contains(number));

        int expectedSize = Integer.parseInt(number);
        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        int actualSize = results.size();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String option){
        getDriver().findElement(By.xpath("//span[text()='Priority Mail | USPS']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//a[text()='" + button + " ']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleContains("Sign In"));
        WebElement username = getDriver().findElement(By.xpath("//input[@id='username']"));
        assertThat(username.isDisplayed()).isTrue();

        // switch back
        getDriver().switchTo().window(originalWindow);
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

    @When("I go to {string} under {string}")
    public void iGoToUnder(String option, String menu) {
        WebElement menuTab = getDriver().findElement(By.xpath("//a[@class='menuitem'][text()='" + menu + "']"));
        WebElement tool = getDriver().findElement(By.xpath("//a[text()='" + option + "']"));

        new Actions(getDriver())
                .moveToElement(menuTab)
                .click(tool)
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//fieldset//button[@type='submit']")).click();
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) {

        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(overlay));
        wait.until(ExpectedConditions.invisibilityOf(overlay));

        getDriver().findElement(By.xpath("//a[text()='" + button + " ']")).click();
    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String function) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + function + "')]")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
       getDriver().findElements(By.xpath("//td[@style='width:67px;']")).toString();


    }
}