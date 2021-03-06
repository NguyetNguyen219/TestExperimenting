package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGooglePlayAppTest extends SeleniumBaseGooglePlayTest {

    private String appName = "Monde Ludique";

    @Test(description = "Search an application and check the title of web")
    public void testSearchTitleOnGooglePlayApps() {
        String title = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(appName)
                .clickSearchButton()
                .getTitle();

        Assert.assertTrue(title.contains(appName));
    }

    @Test(priority = 1)
    public void testSearchFilterOptionOnGooglePlayApps() {
        String filterCurrentOptionName = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(appName)
                .clickSearchButton()
                .getFilterBoxCurrentOptionName();

        Assert.assertEquals(filterCurrentOptionName, "Android apps");
    }
}
