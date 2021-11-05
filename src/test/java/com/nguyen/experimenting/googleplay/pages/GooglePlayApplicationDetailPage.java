package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePlayApplicationDetailPage extends BaseGooglePlayPage {

    @FindBy(xpath = "//div[@class='D0ZKYe ']/div/div/c-wiz[1]//span")
    WebElement appTitle;

    public String getAppTitle() {
        BaseTest.LOGGER.info("Get the current title");
        return appTitle.getText();
    }
}
