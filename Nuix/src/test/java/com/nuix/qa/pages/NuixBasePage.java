package com.nuix.qa.pages;

import com.nuix.qa.core.selenium.DriverHelper;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class NuixBasePage extends DriverHelper {

    public abstract ExpectedCondition getPageloadCondition();
    // Write rest of code which can be shared by any web page in general
}
