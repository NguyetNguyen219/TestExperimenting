package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import com.nguyen.experimenting.google.pages.GoogleSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGoogleSearchResultPageTest extends SeleniumBaseGoogleTest {

    @Test
    public void testPresentComponentsInResultPage() {

        GoogleSearchResultPage searchResultPage = new GoogleHomeSearchPage()
                .setTextToSearchField("pandora")
                .clickGoogleSearchBtn();

        Assert.assertTrue(searchResultPage.verifyInputSearchField());
        Assert.assertTrue(searchResultPage.verifyResultStatus());
        Assert.assertTrue(searchResultPage.verifyPagesNumberNavigator());
    }
}
