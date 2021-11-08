package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This is Google Play home page class representation
 */
public class GooglePlayHomePage extends BaseGooglePlayPage {

    @FindBy(xpath = "//li[@class='uQeS5e qKjvAb iZhiic']/a")
    WebElement appMenuOption;

    /**
     * method wait for Apps option to be clickable
     */
    public void waitForAppsMenuOptionToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(appMenuOption));
    }

    /**
     * method click on Apps option
     * @return GooglePlayApplicationPage .this
     */
    public GooglePlayApplicationPage clickAppsMenuOption() {
        waitForAppsMenuOptionToBeClickable();
        appMenuOption.click();
        BaseTest.LOGGER.info("Click the app menu option");


        return new GooglePlayApplicationPage();
    }
}
