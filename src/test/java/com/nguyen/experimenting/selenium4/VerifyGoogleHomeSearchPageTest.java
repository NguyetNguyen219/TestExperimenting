package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGoogleHomeSearchPageTest extends SeleniumBaseGoogleTest {

    @Test
    public void testPresenceOfElementsOnDoodlePage() {

        GoogleHomeSearchPage homeSearchPage = new GoogleHomeSearchPage();

        Assert.assertTrue(homeSearchPage.verifySearchMainButton());
        Assert.assertTrue(homeSearchPage.verifySearchMainField());
    }
}
