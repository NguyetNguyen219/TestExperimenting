package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePlayApplicationDetailPage extends BaseGooglePlayPage {

    WebElement appTitle = DriverWrapper.getDriver().findElement(By.xpath(
            "//*[@id='fcxH9b']/div[4]/c-wiz[5]//div[2]//*//c-wiz[1]/c-wiz[1]//div[2]//div[1]/c-wiz[1]/h1/span"));

    public String getAppTitle() {
        return appTitle.getText();
    }
}
