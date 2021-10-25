package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchResultPageTest extends SeleniumBaseTest {

    @Test
    public void testPresenceOfResultStatus() {

        boolean resultStatusDisplayed = new GoogleHomeSearchPage()
                .setTextToSearchField("pandora")
                .clickGoogleSearchBtn()
                .verifyResultStatus();

        Assert.assertTrue(resultStatusDisplayed);
    }

    @Test
    public void testPresenceOfPagesNumberNavigator() {

        boolean navigatorDisplayed = new GoogleHomeSearchPage()
                .setTextToSearchField("pandora")
                .clickGoogleSearchBtn()
                .verifyPagesNumberNavigator();

        Assert.assertTrue(navigatorDisplayed);
    }
}
