package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This is Google Play app detail page class representation
 */
public class GooglePlayApplicationDetailPage extends BaseGooglePlayPage {

    @FindBy(xpath = "//div[@class='sIskre']//h1/span")
    WebElement appTitle;

    /**
     * method wait for the visibility of app's title
     */
    public void waitForAppTitleVisibility() {
        wait.until(ExpectedConditions.visibilityOf(appTitle));
    }

    /**
     * method get the app's title in detail page
     * @return String
     */
    public String getAppTitle() {
        waitForAppTitleVisibility();
        BaseTest.LOGGER.info("Get the current title");
        return appTitle.getText();
    }
}
