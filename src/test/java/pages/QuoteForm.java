package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.*;

public class QuoteForm {

    // fields

    private String url;
    private String title;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "middleName")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(id = "dateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(name = "countryOfOrigin")
    private WebElement country;

    @FindBy(xpath = "//input[@value='male']")
    private WebElement gender;

    @FindBy(name = "allowedToContact")
    private WebElement allowedToContact;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(name = "carMake")
    private WebElement carMake;

    @FindBy(id = "thirdPartyButton")
    private WebElement thirdPartyButton;

    @FindBy(id = "username-error")
    private WebElement usernameError;

    @FindBy(id = "email-error")
    private WebElement emailError;

    @FindBy(id = "password-error")
    private WebElement passwordError;

    @FindBy(id = "confirmPassword-error")
    private WebElement confirmPasswordError;

    @FindBy(id = "name-error")
    private WebElement nameError;

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private WebElement agreedToPrivacyPolicyError;



    // constructor

    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    // methods

    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }


    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillFullName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void agreeWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillDateOfBirth(String month, String year, String date) {
        dateOfBirth.click();
        Select selectMonth = new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        selectMonth.selectByValue(month);

        Select selectYear = new Select(getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        selectYear.selectByValue(year);

        getDriver().findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + date + "']")).click();
    }

    public void fillCountry(String value) {
        Select selectCountry = new Select(country);
        selectCountry.selectByValue(value);
    }

    public void clickGender() {
        gender.click();
    }

    public void clickAllowedToContact() {
        if (!allowedToContact.isSelected()) {
            allowedToContact.click();
        }
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void fillCarMake(String value) {
        Select selectCar = new Select(carMake);
        selectCar.selectByValue(value);
    }

    public void clickThirdPartyButton() {
        thirdPartyButton.click();
        getDriver().switchTo().alert().accept();
    }

    public String usernameErrorValue() {
        return usernameError.getText();
    }

    public String emailErrorValue() {
        return emailError.getText();
    }

    public String passwordErrorValue() {
        return passwordError.getText();
    }

    public String confirmPasswordErrorValue() {
        return confirmPasswordError.getText();
    }

    public String nameErrorValue() {
        return nameError.getText();
    }

    public String agreedToPrivacyPolicyErrorValue() {
        return agreedToPrivacyPolicyError.getText();
    }

    public String getName(){
        return name.getAttribute("value");
    }


}