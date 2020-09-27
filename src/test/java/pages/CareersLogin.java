package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersLogin extends Page {

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement username;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement submitButton;

    public CareersLogin fillUsername(String value){
        username.sendKeys(value);
        return this;
    }

    public CareersLogin fillPassword(String value){
        password.sendKeys(value);
        return this;
    }

    public void submit(){
        submitButton.click();
    }
}
