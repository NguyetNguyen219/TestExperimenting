package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomeSearchPage extends BaseGooglePage {

    @FindBy(xpath = "//*[@class='gLFyf gsfi']")
    WebElement ggSearchField;
    @FindBy(xpath = "//body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")
    WebElement ggDoodleBtn;
    @FindBy(xpath = "//div[@class = 'FPdoLc lJ9FBc']//input[1]")
    WebElement ggSearchBtn;

    public void waitForSearchButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(ggSearchBtn));
    }

    public void waitForDoodleButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(ggDoodleBtn));
    }

    public boolean verifySearchMainButton() {
        BaseTest.LOGGER.info("Verify if the search button is display");
        return ggSearchBtn.isDisplayed();
    }

    public boolean verifySearchMainField() {
        BaseTest.LOGGER.info("Verify if the search field is display");
        return ggSearchField.isDisplayed();
    }

    public GoogleHomeSearchPage setTextToSearchField(String text) {
        BaseTest.LOGGER.info("Write '"+ text+ "' in the search field");
        ggSearchField.sendKeys(text);

        waitForSearchButtonToBeClickable();
        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchBtn() {
        BaseTest.LOGGER.info("Click search button");

        ggSearchBtn.click();
        return new GoogleSearchResultPage();
    }

    public GoogleDoodlesPage clickGoogleDoodleBtn() {
        BaseTest.LOGGER.info("Click Google doodle button");
        waitForDoodleButtonToBeClickable();
        ggDoodleBtn.click();

        return new GoogleDoodlesPage();
    }
}
