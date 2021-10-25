package com.nguyen.experimenting.selenium4;

import com.nguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchGoogleDoodlePageTest extends SeleniumBaseTest {

    @Test
    public void testSearchOnDoodlePage() {
        String searchStr = "halloween";

        String resName = new GoogleHomeSearchPage()
                .clickGoogleDoodleBtn()
                .setTextToSearchField(searchStr)
                .clickOnSearchBtn()
                .getFirstElementNameInArchiveList();

        Assert.assertTrue(resName
                    .toLowerCase()
                    .contains(searchStr));
    }
}
