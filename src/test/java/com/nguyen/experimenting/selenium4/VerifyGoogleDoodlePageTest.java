package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGoogleDoodlePageTest extends SeleniumBaseGoogleTest {

    @Test
    public void testPresenceOfElementsOnDoodlePage() {

        boolean searchFieldDisplayed = new GoogleHomeSearchPage()
                .clickGoogleDoodleBtn()
                .verifySearchField();

        Assert.assertTrue(searchFieldDisplayed);

        String pageUrl = DriverWrapper.getDriver().getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("doodles"));
    }
}
