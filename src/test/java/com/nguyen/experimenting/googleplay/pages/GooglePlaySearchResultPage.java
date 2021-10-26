package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.google.pages.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePlaySearchResultPage extends BaseGooglePlayPage {

    private WebElement searchFilterDropBox = DriverWrapper.getDriver()
            .findElement(By.id("action-dropdown-parent-Android apps"));
    private WebElement firstResultInList = DriverWrapper.getDriver().findElement(By.xpath(
            "//*[@id='fcxH9b']/div[4]/c-wiz[5]//div[2]//*//c-wiz//div[2]/div[1]/c-wiz//*/div[2]//*/div[1]//*/div[1]/a/div"));

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }

    public String getFirstAppNameInList() {
        return firstResultInList.getText();
    }

    public void waitForFirstAppVisibility() {
        wait.until(ExpectedConditions.visibilityOf(firstResultInList));
    }

    public GooglePlayApplicationDetailPage clickFirstAppInList() {
        waitForFirstAppVisibility();
        firstResultInList.click();

        return new GooglePlayApplicationDetailPage();
    }
}
