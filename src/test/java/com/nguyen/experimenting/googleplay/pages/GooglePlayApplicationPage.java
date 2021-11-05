package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeUnit;

public class GooglePlayApplicationPage extends BaseGooglePlayPage {

    @FindBy(xpath = "//*[@id='fcxH9b']/div[1]/c-wiz[2]//*//*/div[4]")
    WebElement topChartsMenuOption;

    public GooglePlayApplicationPage setTextToSearchField(String appName) {
        BaseTest.LOGGER.info("Write '"+ appName+ "' in the search field");
//        wait.until(ExpectedConditions.)

        searchField.sendKeys(appName);

        return this;
    }

    public GooglePlaySearchResultPage clickSearchButton() {
        BaseTest.LOGGER.info("Click search button");
        waitForSearchButtonToBeClickable();
        searchBtn.click();

        return new GooglePlaySearchResultPage();
    }

    public GooglePlayApplicationPage clickTopChartsMenuOption() {
        BaseTest.LOGGER.info("Click top charts option");
        topChartsMenuOption.click();

        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public String getTopFreeAppHeaderName() {
        BaseTest.LOGGER.info("Get header name of the top free app");

        WebElement topFreeAppHeader = DriverWrapper.getDriver()
                .findElement(By.xpath("//*[@id='fcxH9b']/div[4]/c-wiz[3]/*//*//c-wiz/" +
                        "c-wiz[1]/c-wiz//div[1]/div[1]//h2"));
        return topFreeAppHeader.getText();
    }
}
