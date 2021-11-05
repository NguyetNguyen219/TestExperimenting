package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class GooglePlaySearchResultPage extends BaseGooglePlayPage {

    @FindBy(id = "action-dropdown-parent-Android apps")
    WebElement searchFilterDropBox;


    public WebElement getFirstItemLinkInResultList() {
        return DriverWrapper.getDriver().findElement(By.xpath(
                "//div[@class='ZmHEEd ']/div[1]/*/div/*/div[2]/*//*/div[1]/a/div"));
    }

    public String getTitle() {
        BaseTest.LOGGER.info("Get the page's title");

        return DriverWrapper.getDriver().getTitle();
    }

    public String getFirstAppNameInList() {
        BaseTest.LOGGER.info("Get first app name in list");
        return getFirstItemLinkInResultList().getText();
    }

    public String getFilterBoxCurrentOptionName() {
        BaseTest.LOGGER.info("Get current option name in filter box");
        return searchFilterDropBox.findElement(By.className("TwyJFf")).getText();
    }

    public GooglePlayApplicationDetailPage clickFirstAppInList() {
        WebElement element = getFirstItemLinkInResultList();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        return new GooglePlayApplicationDetailPage();
    }
}
