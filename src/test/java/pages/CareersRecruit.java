package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CareersRecruit extends CareersHeader {

    private WebElement closeButton (String position) {
        return getByXpath("//h4[text()='" + position + "']/../../../*/button");
//        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card')]//button");
    }

    private WebElement positionCard(String position){
        return getByXpath("//h4[text()='" + position + "']");
//        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private List<WebElement> allPositionCards(String title) {
        return getAllByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

//    @FindBy(className = "row")
//    private WebElement allPositionsCards;

    public void closeButtonClick(String value){
        mouseOver(positionCard(value));
        click(closeButton(value));
    }

    public CareersRecruit removePosition(String title) {
        WebElement card = positionCard(title);
        WebElement closeButton = closeButton(title);

        mouseOver(card);
        waitForClickable(closeButton);
        click(closeButton);
        waitForDisappear(card);

        return new CareersRecruit();
    }

//    public String getAllPositionsText(){
//        return allPositionsCards.getText();
//    }

    public boolean isPositionVisible(String title) {
//        List<WebElement> cards = allPositionCards(title);
//        if (cards.isEmpty()) {
//            return false;
//        } else {
//            return cards.get(0).isDisplayed();
//        }
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
