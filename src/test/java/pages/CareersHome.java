package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//a[@href='/login']/button")
    private WebElement loginButton;

   public void setLoginButtonClick(){
        click(loginButton);

   }
}
