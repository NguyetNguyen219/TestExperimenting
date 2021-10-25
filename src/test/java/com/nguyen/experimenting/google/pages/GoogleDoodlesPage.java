package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleDoodlesPage extends BaseGooglePage {

    private WebElement searchDoodleField = DriverWrapper.getDriver().findElement(By.id("searchinput"));
    private WebElement searchDoodleBtn = DriverWrapper.getDriver().findElement(By.id("searchbtn"));

    private final WebDriverWait wait = new WebDriverWait(DriverWrapper.getDriver(), 10);

    public boolean verifySearchField() {
        return searchDoodleField.isDisplayed();
    }

    public GoogleDoodlesPage setTextToSearchField(String doodle) {
        searchDoodleField.sendKeys(doodle);
        return this;
    }

    public GoogleDoodlesPage clickOnSearchBtn() {
        searchDoodleBtn.click();
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        return this;
    }

    public String getFirstElementNameInArchiveList() {
        WebElement firstElementName = DriverWrapper.getDriver()
                .findElement(By.xpath("//*[@id='archive-list']/li[1]/div[1]/div[2]/div[2]/a"));
        return firstElementName.getAttribute("title");
    }
}
