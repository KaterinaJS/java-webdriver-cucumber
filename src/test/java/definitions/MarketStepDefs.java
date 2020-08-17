package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import support.TestContext;

import static support.TestContext.getDriver;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        if (page.equals("quote")) {
            getDriver().get("https://skryabin.com/market/quote.html");
        } else if (page.equals("google")) {
            getDriver().get("https://www.google.com/");
        } else if (page.equals("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        } else {
            throw new RuntimeException("Unsupported page! " + page);
        }

    }

    @And("I print page details")
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

    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String screenSize) {
        switch (screenSize){
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

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
    }
}