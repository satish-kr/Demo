package com.nuix.qa.pages.bookings;

import io.cucumber.java.hu.De;
import lombok.Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.nuix.qa.pages.NuixBasePage;

import java.util.Locale;

public class BookingsBasePage extends NuixBasePage {

    @FindBy(xpath = "//a[@class='bui-button bui-button--secondary js-header-login-link']//span[@class = 'bui-button__text'][contains(text(), 'Sign in')]")
    WebElement signInButton;

    @FindBy(xpath = "//span[@class = 'bui-tab__text'][contains( text(), 'Car rentals')]")
    WebElement carRentalTab;

    @FindBy(xpath = "//a[@class='bui-tab__link bui-tab__link--selected']")
    WebElement staysTab;

    @Override
    public ExpectedCondition getPageloadCondition() {
        return null;
    }

    // Write code specific to Bookings.com home page which will be shared, like navigation , sign in etc
    // Add navigation and other common elements
    // Switch car rentals, home pge and  stay

    public void navigateTo(String navigationMenu) {
        switch (navigationMenu.toLowerCase()) {
            case "stays" -> this.staysTab.click();
            case "car rentals" -> this.carRentalTab.click();
            case "sign in" -> this.signInButton.click();
            // More navigation options
            default -> new AssertionError(" Not a valid menu item");
        }
    }
}
