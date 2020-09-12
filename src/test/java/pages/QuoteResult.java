package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult {

    public QuoteResult() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name="username")
    private WebElement usernameResult;

    @FindBy(name="email")
    private WebElement emailResult;

    @FindBy(name="name")
    private WebElement nameResult;

    @FindBy(name="password")
    private WebElement passwordResult;

    @FindBy(name="agreedToPrivacyPolicy")
    private WebElement agreedToPrivacyPolicyResult;

    @FindBy(name="firstName")
    private WebElement firstNameResult;

    @FindBy(name="lastName")
    private WebElement lastNameResult;

    public String usernameValue() {
        return usernameResult.getText();
    }

    public String emailValue() {
        return emailResult.getText();
    }

    public String nameValue() {
        return nameResult.getText();
    }

    public String passwordValue() {
        return passwordResult.getText();
    }

    public String agreedToPrivacyPolicyResultValue() {
        return agreedToPrivacyPolicyResult.getText();
    }

    public String firstNameValue() {
        return firstNameResult.getText();
    }

    public String lastNameValue() {
       return lastNameResult.getText();
    }

}