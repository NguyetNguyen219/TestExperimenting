package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleHomeSearchPageTest extends SeleniumBaseTest {

    @Test
    public void testPresenceOfSearchButtonOnDoodlePage() {

        boolean searchButtonDisplayed = new GoogleHomeSearchPage()
                .verifySearchMainButton();

        Assert.assertTrue(searchButtonDisplayed);
    }

    @Test
    public void testPresenceOfSearchFieldOnDoodlePage() {

        boolean searchFieldDisplayed = new GoogleHomeSearchPage()
                .verifySearchMainField();

        Assert.assertTrue(searchFieldDisplayed);
    }
}
