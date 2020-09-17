package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class ShippingToUps {

    public ShippingToUps() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath="//div[@class='ups-section']")
    private WebElement resultBox;

    @FindBy(id="nbsBackForwardNavigationBackButton")
    private WebElement backButton;

    @FindBy(id="nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelButton;

    @FindBy(id="nbsCancelShipmentWarningYes")
    private WebElement confirmCancelButton;

    public String resultBoxContent(){
       return resultBox.getText();
    }

    public void cancelButtonClick(){
        getExecutor().executeScript("arguments[0].click();", cancelButton);
        getExecutor().executeScript("arguments[0].click();", confirmCancelButton);
    }


}
