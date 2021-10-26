package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomeSearchPage extends BaseGooglePage {

    private WebElement ggSearchField = DriverWrapper.getDriver().findElement(By.xpath("//*[@class='gLFyf gsfi']"));
    private WebElement ggDoodleBtn = DriverWrapper.getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]"));
    private WebElement ggSearchBtn = DriverWrapper.getDriver().findElement(By.className("gNO89b"));

    public void waitForSearchButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(ggSearchBtn));
    }

    public void waitForDoodleButtonToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(ggDoodleBtn));
    }

    public boolean verifySearchMainButton() {
        return ggSearchBtn.isDisplayed();
    }

    public boolean verifySearchMainField() {
        return ggSearchField.isDisplayed();
    }

    public GoogleHomeSearchPage setTextToSearchField(String text) {
        ggSearchField.sendKeys(text);

        waitForSearchButtonToBeClickable();
        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchBtn() {
        ggSearchBtn.click();
        return new GoogleSearchResultPage();
    }

    public GoogleDoodlesPage clickGoogleDoodleBtn() {
        waitForDoodleButtonToBeClickable();
        ggDoodleBtn.click();

        return new GoogleDoodlesPage();
    }
}
