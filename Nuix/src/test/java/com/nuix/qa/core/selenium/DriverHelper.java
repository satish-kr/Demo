package com.nuix.qa.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.nuix.qa.pages.NuixBasePage;

/**
 * Class common to both steps and page for driver intractions to be available in both the closses
 * Both com.nuix.qa.pages and steps will extend this
 */
public class DriverHelper {

    protected WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    protected <T extends NuixBasePage> T get(Class<T> pageClass){
        return PageFactory.initElements(getDriver(), pageClass );
    }
    protected <T extends NuixBasePage> T getWithWait(Class<T> pageClass){
        T page = get(pageClass);
        ExpectedCondition pageLoadCondition = page.getPageloadCondition();
        return PageFactory.initElements(getDriver(), pageClass );
    }

    protected <T extends NuixBasePage> T openPageWithWait(Class<T> pageClass, String url){
        WebDriver webDriver = getDriver();
        webDriver.navigate().to(url);
        return get(pageClass);
    }

    // dummy methods for demo
    // more such methods

}
