package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleDoodlePageTest extends SeleniumBaseTest {

    @Test
    public void testPresenceOfSearchFieldOnDoodlePage() {

        boolean searchFieldDisplayed = new GoogleHomeSearchPage()
                .clickGoogleDoodleBtn()
                .verifySearchField();

        Assert.assertTrue(searchFieldDisplayed);
    }

    @Test
    public void testDoodlePageUrl() {

        String pageUrl = DriverWrapper.getDriver().getCurrentUrl();

        Assert.assertTrue(pageUrl.contains("doodle"));
    }
}
