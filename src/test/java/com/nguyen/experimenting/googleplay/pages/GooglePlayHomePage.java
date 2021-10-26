package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class GooglePlayHomePage extends BaseGooglePlayPage {

    private WebElement appMenuOption = DriverWrapper.getDriver()
            .findElement(By.xpath("//*[@id='fcxH9b']/div[1]/c-wiz[1]/*/li[2]/a"));

    public void waitForAppsMenuOption() {
        wait.until(ExpectedConditions.elementToBeClickable(appMenuOption));
    }

    public GooglePlayApplicationPage clickAppsMenuOption() {
        waitForAppsMenuOption();
        appMenuOption.click();

        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(1200, TimeUnit.MILLISECONDS);
        return new GooglePlayApplicationPage();
    }
}
