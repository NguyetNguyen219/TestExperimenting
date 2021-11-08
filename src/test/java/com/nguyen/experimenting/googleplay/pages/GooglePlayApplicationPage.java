package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * This is Google Play apps page class representation
 */
public class GooglePlayApplicationPage extends BaseGooglePlayPage {

    @FindBy(xpath = "//div[@class='t5eBue ovVTif']/div[4]")
    WebElement topChartsMenuOption;

    public void waitForTopChartOptionVisibility() {
        wait.until(ExpectedConditions.visibilityOf(topChartsMenuOption));
    }

    /**
     * method set %appName% to google play search field
     *
     * @param appName - string variable represent the text to send to search field
     * @return GooglePlayApplicationPage .this
     */
    public GooglePlayApplicationPage setTextToSearchField(String appName) {
        waitForTopChartOptionVisibility();
        BaseTest.LOGGER.info("Write '"+ appName+ "' in the search field");

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
