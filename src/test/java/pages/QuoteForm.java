package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class QuoteForm {

    // fields

    private String url;
    private String title;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

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
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
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

}