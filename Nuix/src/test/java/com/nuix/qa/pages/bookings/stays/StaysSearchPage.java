package com.nuix.qa.pages.bookings.stays;

import com.nuix.qa.pages.bookings.BookingsBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Date;

public class StaysSearchPage extends BookingsBasePage {
    @FindBy(xpath = "//a[@class='bui-tab__link bui-tab__link--selected']")
    WebElement staysTab;

    @FindBy(xpath = "//input[@id='ss']")
    WebElement searchBox;

    @FindBy(xpath = "//div[@class='sb-date-field__display'][contains(text(),'Check-in')]")
    WebElement checkInDate;

    @FindBy(id = "")
    WebElement checkOutDate;

    @FindBy(xpath = "//div[@class='xp__button']")
    WebElement searchButton;

    @Override
    public ExpectedCondition<WebElement> getPageloadCondition() {
        return ExpectedConditions.elementToBeClickable(this.staysTab);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

    public void searchQuery(String query) {
        this.searchBox.sendKeys(query);
    }

    public void selectDates(Date date) {
        // Date input
    }

}