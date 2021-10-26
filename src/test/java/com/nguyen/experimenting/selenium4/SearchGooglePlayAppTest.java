package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGooglePlayAppTest extends SeleniumBaseGooglePlayTest {

    @Test
    public void testSearchOnGooglePlayApps() {
        String appName = "Monde Ludique";

        String title = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(appName)
                .clickSearchButton()
                .getTitle();

        Assert.assertTrue(title.contains(appName));
    }
}
