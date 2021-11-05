package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.googleplay.pages.GooglePlayApplicationDetailPage;
import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import com.nguyen.experimenting.googleplay.pages.GooglePlaySearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGooglePlayAppDetailTest extends SeleniumBaseGooglePlayTest {

    @Test
    public void testGooglePlayAppName() throws InterruptedException {
        GooglePlaySearchResultPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField("Monde Ludique")
                .clickSearchButton();

        String name = resultPage.getFirstAppNameInList();

        Assert.assertEquals(name, resultPage.clickFirstAppInList().getAppTitle());
    }

    @Test(testName = "test-search-page")
    public void testGooglePlayAppPageUrl() throws InterruptedException {
        GooglePlayApplicationDetailPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField("Monde Ludique")
                .clickSearchButton()
                .clickFirstAppInList();

        Assert.assertTrue(DriverWrapper.getDriver().getCurrentUrl().contains("mondeludique"));
    }
}
