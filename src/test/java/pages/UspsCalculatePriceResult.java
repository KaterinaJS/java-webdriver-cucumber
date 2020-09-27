package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsCalculatePriceResult extends Page {

    @FindBy(id = "quantity-0")
    private WebElement quantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(id = "cost-0")
    private WebElement cost;

    public void inputQuantity(String value){
        sendKeys(quantity, value);
    }

    public void calculateButtonClick(){
        click(calculateButton);
    }

    public String getCostValue(){
        return cost.getText();
    }
}
