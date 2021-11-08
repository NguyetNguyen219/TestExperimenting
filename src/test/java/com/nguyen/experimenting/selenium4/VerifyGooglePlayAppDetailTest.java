package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.core.DriverWrapper;
import com.nguyen.experimenting.googleplay.pages.GooglePlayApplicationDetailPage;
import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import com.nguyen.experimenting.googleplay.pages.GooglePlaySearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGooglePlayAppDetailTest extends SeleniumBaseGooglePlayTest {

    static String title = "Monde Ludique";

    @Test(description = "Test the app's title in list equal with its name in app detail page")
    public void testGooglePlayAppName() {
        GooglePlaySearchResultPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField(title)
                .clickSearchButton();

        String name = resultPage.getAppNameInListByTitle(title);

        Assert.assertEquals(name, resultPage.clickAppInListByTitle(title).getAppTitle());
    }

    @Test(description = "Test if the url of google app page contains the name of that app")
    public void testGooglePlayAppPageUrl() {
        GooglePlayApplicationDetailPage resultPage = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .setTextToSearchField("Monde Ludique")
                .clickSearchButton()
                .clickAppInListByTitle(title);

        Assert.assertTrue(DriverWrapper.getDriver().getCurrentUrl().contains("mondeludique"));
    }
}
