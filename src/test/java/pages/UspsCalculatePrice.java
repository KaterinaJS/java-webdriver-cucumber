package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UspsCalculatePrice extends UspsHeader{

    @FindBy(id="CountryID")
    private WebElement country;

    private WebElement option (String shape) {
        return getDriver().findElement(By.xpath("//input[@value='" + shape + "']"));
    }

    public void selectCountry(String value) {
        new Select(country).selectByVisibleText(value);
    }

    public void selectOption(String shape){
        click(option(shape));
    }
}
