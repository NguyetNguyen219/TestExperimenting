package com.nguyen.experimenting.googleplay.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseGooglePlayPage {
    @FindBy(id = "gbqfq")
    protected WebElement searchField;
    @FindBy(id = "gbqfb")
    protected WebElement searchBtn;

    protected final WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 8);

    public BaseGooglePlayPage() {
        PageFactory.initElements(DriverWrapper.getDriver(), this);
    }

    public void waitForSearchButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }
}
