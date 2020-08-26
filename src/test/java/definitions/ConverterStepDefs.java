package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConverterStepDefs {
    @When("I click on {string}")
    public void iClickOn(String option) {
        getDriver().findElement(By.xpath("//a[contains(@href,'" + option + "')]")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String from, String to) {
        Select fromSelect = new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']")));
        fromSelect.selectByVisibleText(from);

        Select toSelect = new Select(getDriver().findElement(By.xpath("//select[@id='calTo']")));
        toSelect.selectByVisibleText(to);
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String numberFrom, String numberTo) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(numberFrom);
        assertThat(getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value").equals(numberTo));
    }
}
