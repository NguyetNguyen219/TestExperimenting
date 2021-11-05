package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.BaseTest;
import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class GoogleDoodlesPage extends BaseGooglePage {

    @FindBy(id = "searchinput")
    WebElement searchDoodleField;
    @FindBy(id = "searchbtn")
    WebElement searchDoodleBtn;

    public boolean verifySearchField() {
        return searchDoodleField.isDisplayed();
    }

    public GoogleDoodlesPage setTextToSearchField(String text) {
        BaseTest.LOGGER.info("Write '"+ text + "' to search field");
        searchDoodleField.sendKeys(text);
        return this;
    }

    public GoogleDoodlesPage clickOnSearchBtn() {
        BaseTest.LOGGER.info("Click on search button");
        searchDoodleBtn.click();
        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        return this;
    }

    public String getFirstElementNameInArchiveList() {
        BaseTest.LOGGER.info("Get the name of first element in archive list");
        WebElement firstElementName = DriverWrapper.getDriver()
                .findElement(By.xpath("//*[@id='archive-list']/li[1]/div[1]/div[2]/div[2]/a"));
        return firstElementName.getAttribute("title");
    }
}
