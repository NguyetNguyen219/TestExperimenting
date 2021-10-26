package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseGooglePage {

    protected final WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 5);
}
