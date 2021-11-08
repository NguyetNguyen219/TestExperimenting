package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This is Google Play search result page class representation
 */
public class GooglePlaySearchResultPage extends BaseGooglePlayPage {

    @FindBy(id = "action-dropdown-parent-Android apps")
    WebElement searchFilterDropBox;

    public void waitForSearchFilterDropBoxVisibility() {
        wait.until(ExpectedConditions.visibilityOf(searchFilterDropBox));
    }

    /**
     * method finds an item in result list by %title% and return it
     * @param title - string represent title of an item
     * @return WebElement
     */
    public WebElement getItemLinkInResultListByTitle(String title) {
        waitForSearchFilterDropBoxVisibility();
        return DriverWrapper.getDriver().findElement(By.xpath(
                "//div[@title='" + title + "']"));
    }

    /**
     * method returns the title of this page
     * @return String
     */
    public String getTitle() {
        waitForSearchFilterDropBoxVisibility();
        BaseTest.LOGGER.info("Get the page's title");

        return DriverWrapper.getDriver().getTitle();
    }

    /**
     * method finds an item in result list by %title% and return its name
     * @param title - string represent title of an item
     * @return String name of item
     */
    public String getAppNameInListByTitle(String title) {
        BaseTest.LOGGER.info("Get first app name in list");
        return getItemLinkInResultListByTitle(title).getText();
    }

    public String getFilterBoxCurrentOptionName() {
        waitForSearchFilterDropBoxVisibility();
        BaseTest.LOGGER.info("Get current option name in filter box");
        return searchFilterDropBox.findElement(By.className("TwyJFf")).getText();
    }

    public GooglePlayApplicationDetailPage clickAppInListByTitle(String title) {
        WebElement element = getItemLinkInResultListByTitle(title);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        return new GooglePlayApplicationDetailPage();
    }
}
