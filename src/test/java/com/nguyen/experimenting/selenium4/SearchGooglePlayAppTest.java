package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import org.testng.annotations.Test;

public class SearchGooglePlayAppTest extends SeleniumBaseGooglePlayTest {

    @Test
    public void testSearchOnGooglePlayApps() {
        new GooglePlayHomePage().clickAppsMenuOption();
    }
}
