package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.googleplay.pages.GooglePlayHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyGooglePlayAppsTopChartsTest extends SeleniumBaseGooglePlayTest {

    @Test
    public void testTopFreeAppsHeaderInTopCharts() {
        String headerName = new GooglePlayHomePage()
                .clickAppsMenuOption()
                .clickTopChartsMenuOption()
                .getTopFreeAppHeaderName();

        Assert.assertEquals(headerName, "Top free apps");
    }
}
