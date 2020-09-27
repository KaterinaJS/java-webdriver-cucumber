package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//a[@href='/login']/button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement userName;

    @FindBy(xpath = "//a[@href='/recruit']/button")
    private WebElement recruitButton;

   public void loginButtonClick(){
        click(loginButton);
   }

   public String getUserName(){
       return userName.getText();
   }

   public void recruitButtonClick(){
       click(recruitButton);
   }
}
