package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CareersLogin extends CareersHeader {

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

    public CareersHome login(String usernameValue, String passwordValue) {
        sendKeys(username, usernameValue);
        sendKeys(password, passwordValue);
        click(submitButton);
        return new CareersHome();
    }

    public CareersHome login(Map<String, String> user) {
        sendKeys(username, user.get("email"));
        sendKeys(password, user.get("password"));
        click(submitButton);
        return new CareersHome();
    }
}
