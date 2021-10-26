package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GooglePlayApplicationPage extends BaseGooglePlayPage {

    private WebElement topChartsMenuOption = DriverWrapper.getDriver()
            .findElement(By.xpath("//*[@id='fcxH9b']/div[1]/c-wiz[2]//*//*/div[4]"));

    public GooglePlayApplicationPage setTextToSearchField(String appName) {
        searchField.sendKeys(appName);

        return this;
    }

    public GooglePlayApplicationPage clickSearchButton() {
        waitForSearchButtonToBeClickable();
        searchBtn.click();

        return this;
    }

    public GooglePlayApplicationPage clickTopChartsMenuOption() {
        topChartsMenuOption.click();

        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public String getTopFreeAppHeaderName() {
        WebElement topFreeAppHeader = DriverWrapper.getDriver()
                .findElement(By.xpath("//*[@id='fcxH9b']/div[4]/c-wiz[3]/*//*//c-wiz/" +
                        "c-wiz[1]/c-wiz//div[1]/div[1]//h2"));
        return topFreeAppHeader.getText();
    }
}
