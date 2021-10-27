package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GooglePlayApplicationDetailPage extends BaseGooglePlayPage {

    WebElement appTitle = DriverWrapper.getDriver().findElement(By
            .xpath("//div[@class='D0ZKYe']/div/div/c-wiz[1]//span"));

    public String getAppTitle() {
        return appTitle.getText();
    }
}
