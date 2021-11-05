package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGoogleDoodlePageTest extends SeleniumBaseGoogleTest {

    @Test
    public void testSearchOnDoodlePage() {
        LOGGER.info("Start the test.");
        String searchStr = "halloween";

        String resName = new GoogleHomeSearchPage()
                .clickGoogleDoodleBtn()
                .setTextToSearchField(searchStr)
                .clickOnSearchBtn()
                .getFirstElementNameInArchiveList();

        Assert.assertTrue(resName
                    .toLowerCase() // not good
                    .contains(searchStr));
        LOGGER.info("Finish.");
    }
}
