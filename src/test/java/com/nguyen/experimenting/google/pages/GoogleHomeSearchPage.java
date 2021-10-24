package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomeSearchPage extends BaseGooglePage {

    private WebElement ggSearchField = DriverWrapper.getDriver().findElement(By.className("gLFyf gsfi"));
    private WebElement ggDoodleBtn = DriverWrapper.getDriver().findElement(By.className("RNmpXc"));
    private WebElement ggSearchBtn = DriverWrapper.getDriver().findElement(By.className("gNO89b"));

    public GoogleHomeSearchPage setTextToSearchField(String text) throws InterruptedException {
        ggSearchField.sendKeys(text);
        Thread.sleep(500);

        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchBtn() {
        ggSearchBtn.click();
        return new GoogleSearchResultPage();
    }

    public GoogleDoodlesPage clickGoogleDoodleBtn() {
        ggDoodleBtn.click();
        return new GoogleDoodlesPage();
    }
}
