package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGoogleMainPageTest extends SeleniumBaseGoogleTest {

    @Test
    public void testBasingSearchOnGoogleMainPage() {
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchBtn()
                .getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
    }
}
