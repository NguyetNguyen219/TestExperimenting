package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Test extends SeleniumBaseTest {

    @Test
    public void testBasingSearchOnGoogleMainPage() throws InterruptedException {
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("Vietnam")
                .clickGoogleSearchBtn()
                .getTitle();
        Assert.assertTrue(title.contains("Vietnam"));
    }
}
