package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class HomeUps {

    private String url;
    private String title;

    @FindBy(id = "ups-menuLinks2")
    private WebElement shippingTab;

    @FindBy(xpath = "//a[text()='Create a Shipment:']")
    private WebElement createShipment;

    public HomeUps() {
        PageFactory.initElements(getDriver(), this);
        url = "https://www.ups.com/us/en/Home.page";
        title = "Global Shipping & Logistics Services | UPS - United States";
    }

    public void open() {
        getDriver().get(url);
    }

    public void shippingTabClick() {
        shippingTab.click();
    }

    public void createShipmentClick() {
        createShipment.click();
    }
}
