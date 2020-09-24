package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.*;

public class UspsStepDefs {

    UspsHome uspsHome = new UspsHome();
    UspsLookupByZip uspsLookupByZip = new UspsLookupByZip();
    UspsByAddressForm uspsByAddressForm = new UspsByAddressForm();
    UspsByAddressResult uspsByAddressResult = new UspsByAddressResult();
    
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
        WebElement resultForm = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        getWait().until(ExpectedConditions.textToBePresentInElement(resultForm, zip));

//        my solving
//        String resultForm = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
//        assertThat(resultForm.contains(zip));

//        Slava solving with lambda
//        WebElement resultForm = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
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
        getActions()
                .moveToElement(searchMenu)
                .sendKeys(searchInput, search)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter){
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
//        wait.until(ExpectedConditions.invisibilityOf(spinner));
//        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']")).click();
        WebElement filterElement = getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']"));
        getExecutor().executeScript("arguments[0].click();", filterElement);

        getWait().until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String number) {
//        String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
//        assertThat(result.contains(number));

        int expectedSize = Integer.parseInt(number);

        String heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        String headingCount = heading.replaceAll("\\D*", "");
        int parsedHeadingCount = Integer.parseInt(headingCount);

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        int actualSize = results.size();

        assertThat(actualSize).isEqualTo(expectedSize);
        assertThat(actualSize).isEqualTo(parsedHeadingCount);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String option) throws InterruptedException {
//        getDriver().findElement(By.xpath("//span[text()='Priority Mail | USPS']")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {
//        getDriver().findElement(By.xpath("//a[text()='" + button + " ']")).click();
        getDriver().findElement(By.xpath("//a[text()='" + button + "']")).click();

//        int numOfWin = getDriver().getWindowHandles().size();
//        while (getDriver().getWindowHandles().size() < numOfWin + 1) {
////            getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();
//            Thread.sleep(100);
//        }
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        getWait(10).until(ExpectedConditions.titleContains("Sign In"));

        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-username']")));
        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='error-password']")));

        // switch back
        getDriver().switchTo().window(originalWindow);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
//        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(@href, 'faq')]")).click();

        getActions().moveToElement(getDriver().findElement(By.xpath("//a[text()='" + tab + "']"))).perform();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(@href,'faq')]")).click();
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
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class, 'totalsArea')]")).getText();
        int totalCount = Integer.parseInt(totalCountString.replaceAll("\\D*", ""));

        By costListSelector = By.xpath("//td[@idx='7']");
        List<WebElement> costList = getDriver().findElements(costListSelector);
        System.out.println("Expected elements size: " + totalCount);

        // dealing with infinite scroll
        while (costList.size() < totalCount) {
            System.out.println("Actual elements size: " + costList.size());
            int lastIndex = costList.size() - 1;
            getActions().moveToElement(costList.get(lastIndex)).perform();
            costList = getDriver().findElements(costListSelector);
        }
        System.out.println("Actual elements size: " + costList.size());

        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double actualTotal = 0;
        for (WebElement cost : costList) {
            double costTotal = formatter.parse(cost.getText()).doubleValue();
            actualTotal += costTotal;
        }
        System.out.println("Actual total " + actualTotal);

        String expectedTotalString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        double expectedTotal = Double.parseDouble(expectedTotalString);
        System.out.println("Expected total " + expectedTotal);

        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));
    }

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String storeNumber) {
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-store']")).sendKeys(storeNumber);
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-store']/../input[@value='Search']")).click();
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        WebElement result = getDriver().findElement(By.xpath("//div[@class='no-product']/p"));
        assertThat(result.isDisplayed());
        assertThat(result.getText().contains("not match any products"));
    }

    @And("choose mail service Priority Mail")
    public void chooseMailServicePriorityMail() {
       getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("(//label[contains(@for,'Service-Priority')])[1]")));
//        getDriver().findElement(By.xpath("(//label[contains(@for,'Service-Priority')])[1]")).click();
    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int count) {
        String result = getDriver().findElement(By.xpath("//h2[contains(@class,'results-per-page')]")).getText();
        assertThat(result.contains("of " + count + " Results"));
    }

    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//label[contains(@for,'Category-Stamps')]")).click();
    }

    @And("select Vertical stamp Shape")
    public void selectVerticalStampShape() {
        getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//label[contains(@for,'Shape-Vertical')]")));
    }

    @And("I click Blue color")
    public void iClickBlueColor() {
        getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//div[contains(@onclick,'blue/vertical')]")));
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String color, String shape) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[text()='" + color + " ']")).isDisplayed());
        assertThat(getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[text()='" + shape + " ']")).isDisplayed());
    }

    @And("I verify that items below {double} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(double stampCost) {

//        String price = getDriver().findElement(By.xpath("//div[contains(@class,'preview-price')]")).getText();
//        int costs = Integer.parseInt(price.replaceAll("\\D*", ""));


        List<WebElement> rows = getDriver().findElements(By.xpath("//div[contains(@class,'preview-price')]"));

        double lowest = Double.MAX_VALUE;
        for(WebElement item : rows){
            if(item.getText().length() > 8){
                continue;
            } else if(lowest > Double.parseDouble(item.getText().replaceAll("\\D*", ""))){
                lowest = Double.parseDouble(item.getText().replaceAll("\\D*", ""));
            }
        }
        assertThat(lowest < stampCost);

//        for(WebElement price : priceList){
//            System.out.println(price.getText().replaceAll("\\D*", ""));
//            double cost = Double.parseDouble(price.getText().replaceAll("\\D*", ""));
//            System.out.println("my answer");
//            System.out.println(cost);
//           assertThat(cost < stampCost);
    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String serviceName) {
        Select serviceSelect = new Select(getDriver().findElement(By.xpath("//select[@id='passportappointmentType']")));
        serviceSelect.selectByVisibleText(serviceName);
    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String zip) {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//a[@class='searchBtn']")).click();
    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String postOfficeName) {
        assertThat(getDriver().findElement(By.xpath("//div[@id='locationContainer_1']")).getText().contains(postOfficeName));
    }

    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn(String size, String postOffice) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Los Altos')]/../../..")).click();

        assertThat(getDriver().findElement(By.xpath("//div[@class='row poLocationResults']")).getText().contains(size));
    }

    @When("I go to Lookup ZIP page by address OOP")
    public void iGoToLookupZIPPageByAddressOOP() {
        uspsHome.goToLookupByZip();
        uspsLookupByZip.clickFindByAddress();
    }

    @And("I fill out {string} street, {string} city, {string} state OOP")
    public void iFillOutStreetCityStateOOP(String street, String city, String state) {
        uspsByAddressForm.fillStreet(street);
        uspsByAddressForm.fillCity(city);
        uspsByAddressForm.selectState(state);
        uspsByAddressForm.clickFind();
    }

    @Then("I validate {string} zip code exists in the result OOP")
    public void iValidateZipCodeExistsInTheResultOOP(String zip) {
        String actualTotalResult = uspsByAddressResult.getSearchResult();
        assertThat(actualTotalResult).contains(zip);

        boolean areAllItemsContainZip = uspsByAddressResult.areAllResultsContainZip(zip);
        assertThat(areAllItemsContainZip).isTrue();
    }
}