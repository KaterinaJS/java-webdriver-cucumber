package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersRecruit extends Page {

    private WebElement closeButton (String position) {
        return getDriver().findElement(By.xpath("//h4[text()='" + position + "']/../../../*/button"));
    }

    private WebElement positionCard(String position){
        return getDriver().findElement(By.xpath("//h4[text()='" + position + "']"));
    }

    @FindBy(className = "row")
    private WebElement allPositionsCards;

    public void closeButtonClick(String value){
        mouseOver(positionCard(value));
        click(closeButton(value));
    }

    public String getAllPositionsText(){
        return allPositionsCards.getText();
    }
}
