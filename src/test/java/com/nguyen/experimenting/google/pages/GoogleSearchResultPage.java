package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class GoogleSearchResultPage extends BaseGooglePage {

    private WebElement resultStatus = DriverWrapper.getDriver().findElement(By.id("result-stats"));
    private WebElement pagesNumberNavigation = DriverWrapper.getDriver()
            .findElement(By.xpath("//*[@id='xjs']/table/tbody/tr"));
    private WebElement inputSearchField = DriverWrapper.getDriver()
            .findElement(By.xpath("//*[@id='tsf']/div[1]/div[1]/div[2]/div/div[2]/input"));

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }

    public boolean verifyResultStatus() {
        return resultStatus.isDisplayed();
    }

    public boolean verifyInputSearchField() {
        return inputSearchField.isDisplayed();
    }

    public boolean verifyPagesNumberNavigator() {
        JavascriptExecutor js = (JavascriptExecutor) DriverWrapper.getDriver();
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        return pagesNumberNavigation.isDisplayed();
    }
}
