package definitions;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "yahoo":
                getDriver().get("https://www.yahoo.com/");
            case "bing":
                getDriver().get("https://www.bing.com/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            default:
                throw new RuntimeException("Unsupported page! " + page);
        }
    }

    @When("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh")
    public void iGoBackAndForwardThenRefresh() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("JS");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john@smith.example.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("Bob");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify required fields")
    public void iVerifyRequiredFields() {
        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(username.equals("JS"));
        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        assertThat(email.equals("john@smith.example.com"));
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).doesNotContain("12345");
        String name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        assertThat(name.equals("John Bob Smith"));
        String agreedToPolicy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreedToPolicy.equals("true"));
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String screenSize) {
        switch (screenSize) {
            case "phone":
                Dimension d1 = new Dimension(400, 768);
                getDriver().manage().window().setSize(d1);
                break;
            case "desktop":
                Dimension d2 = new Dimension(1024, 768);
                getDriver().manage().window().setSize(d2);
                break;
            default:
                System.out.println("Incorrect screen size");
        }
    }

    @Then("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john@smith.example.com.");
        getDriver().findElement(By.xpath("//input[@id='password']")).click();
        getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john@smith.example.com");
        assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()).isFalse();
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
    }

    @And("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@value='3']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='1980']")).click();
        getDriver().findElement(By.xpath("//a[text()='12']")).click();
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Canada']")).click();
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("1020 Main Str., Palo Alto, CA");
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
    }

    @And("I verify optional fields")
    public void iVerifyOptionalFields() {
        String gender = getDriver().findElement(By.xpath("//b[@name='gender']")).getText();
        assertThat(gender.equals("male"));
        String dOB = getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText();
        assertThat(dOB.equals("04/12/1980"));
        String agreement = getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText();
        assertThat(agreement.equals("accepted"));
        String phone = getDriver().findElement(By.xpath("//b[@name='phone']")).getText();
        assertThat(phone.equals("1234567890"));
        String allowToContact = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        assertThat(allowToContact.equals("true"));
        String country = getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText();
        assertThat(country.equals("Canada"));
        String address = getDriver().findElement(By.xpath("//b[@name='address']")).getText();
        assertThat(address.equals("1020 Main Str., Palo Alto, CA"));
        String car = getDriver().findElement(By.xpath("//b[@name='carMake']")).getText();
        assertThat(car.equals("Toyota"));
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Logs begin >>>>");

        for (LogEntry log : logs) {
            System.out.println(log);
        }

        System.out.println("Logs end >>>>");
    }
}