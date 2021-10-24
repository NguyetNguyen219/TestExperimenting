package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleDoodlesPage extends BaseGooglePage {

    private WebElement searchDoodleField = DriverWrapper.getDriver().findElement(By.id("searchinput"));


}
