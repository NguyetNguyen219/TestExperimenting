package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseGooglePlayPage {

    protected WebElement searchField = DriverWrapper.getDriver().findElement(By.id("gbqfq"));
    protected WebElement searchBtn = DriverWrapper.getDriver().findElement(By.id("gbqfb"));
    protected final WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 5);

    public void waitForSearchButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }
}
