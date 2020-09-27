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

    public void fillUsername(String value){
        username.sendKeys(value);
    }

    public void fillPassword(String value){
        password.sendKeys(value);
    }

    public void submit(){
        submitButton.click();
    }
}
