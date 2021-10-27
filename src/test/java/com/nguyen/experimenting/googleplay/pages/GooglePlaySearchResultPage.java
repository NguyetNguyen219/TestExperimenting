package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GooglePlaySearchResultPage extends BaseGooglePlayPage {

    private WebElement searchFilterDropBox = DriverWrapper.getDriver().findElement(By
            .id("action-dropdown-parent-Android apps"));


    public WebElement getFirstItemLinkInResultList() {
        return DriverWrapper.getDriver().findElement(By.xpath(
                "//div[@class='ZmHEEd ']/div[1]/*/div/*/div[2]/*//*/div[1]/a/div"));
    }

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }

    public String getFirstAppNameInList() {
        return getFirstItemLinkInResultList().getText();
    }

    public GooglePlayApplicationDetailPage clickFirstAppInList() {
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        getFirstItemLinkInResultList().click();

        return new GooglePlayApplicationDetailPage();
    }
}
