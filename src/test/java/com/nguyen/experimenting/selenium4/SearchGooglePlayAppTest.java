package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGooglePlayAppTest extends SeleniumBaseGooglePlayTest {

    private String appName = "Monde Ludique";

    @Test
    public void testSearchTitleOnGooglePlayApps() {
        String title = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(appName)
                .clickSearchButton()
                .getTitle();

        Assert.assertTrue(title.contains(appName));
    }

    @Test
    public void testSearchFilterOptionOnGooglePlayApps() {
        String filterCurrentOptionName = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(appName)
                .clickSearchButton()
                .getFilterBoxCurrentOptionName();

        Assert.assertEquals(filterCurrentOptionName, "Android apps");
    }
}
