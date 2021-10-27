package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.googleplay.pages.GooglePlayApplicationDetailPage;
import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import com.nguyen.experimenting.googleplay.pages.GooglePlaySearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyGooglePlayAppDetailTest extends SeleniumBaseGooglePlayTest {

    @Test
    public void testGooglePlayAppName() {
        GooglePlaySearchResultPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField("Monde Ludique")
                .clickSearchButton();

        DriverWrapper.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String name = resultPage.getFirstAppNameInList();

        Assert.assertEquals(name, resultPage.clickFirstAppInList().getAppTitle());
    }

    @Test
    public void testGooglePlayAppPageUrl() {
        GooglePlayApplicationDetailPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField("Monde Ludique")
                .clickSearchButton()
                .clickFirstAppInList();

        Assert.assertTrue(DriverWrapper.getDriver().getCurrentUrl().contains("mondeludique"));
    }
}
