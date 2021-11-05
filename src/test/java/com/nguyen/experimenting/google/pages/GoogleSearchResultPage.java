package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultPage extends BaseGooglePage {

    @FindBy(id = "result-stats")
    WebElement resultStatus;
    @FindBy(xpath = "//*[@id='xjs']/table/tbody/tr")
    WebElement pagesNumberNavigation;
    @FindBy(xpath = "//*[@id='tsf']/div[1]/div[1]/div[2]/div/div[2]/input")
    WebElement inputSearchField;

    public String getTitle() {
        BaseTest.LOGGER.info("Get the page title");
        return DriverWrapper.getDriver().getTitle();
    }

    public boolean verifyResultStatus() {
        BaseTest.LOGGER.info("Verify that result status is displayed");
        return resultStatus.isDisplayed();
    }

    public boolean verifyInputSearchField() {
        BaseTest.LOGGER.info("Verify that result status is displayed");
        return inputSearchField.isDisplayed();
    }

    public boolean verifyPagesNumberNavigator() {
        BaseTest.LOGGER.info("Verify that page number navigator is displayed");
        JavascriptExecutor js = (JavascriptExecutor) DriverWrapper.getDriver();
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        return pagesNumberNavigation.isDisplayed();
    }
}
