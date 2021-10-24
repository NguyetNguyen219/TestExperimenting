package com.nguyen.experimenting.google.pages;

import com.nguyen.experimenting.core.DriverWrapper;

public class GoogleSearchResultPage extends BaseGooglePage {

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }
}
