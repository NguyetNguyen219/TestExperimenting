package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePlayHomePage extends BaseGooglePlayPage {

    @FindBy(xpath = "//*[@id='fcxH9b']/div[1]/c-wiz[1]/*/li[2]/a")
    WebElement appMenuOption;

    public void waitForAppsMenuOption() {
        wait.until(ExpectedConditions.elementToBeClickable(appMenuOption));
    }

    public GooglePlayApplicationPage clickAppsMenuOption() {
        waitForAppsMenuOption();
        appMenuOption.click();
        BaseTest.LOGGER.info("Click the app menu option");

        return new GooglePlayApplicationPage();
    }
}
