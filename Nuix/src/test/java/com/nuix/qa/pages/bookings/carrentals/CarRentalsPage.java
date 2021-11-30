package com.nuix.qa.pages.bookings.carrentals;

import com.nuix.qa.pages.NuixBasePage;
import com.nuix.qa.pages.bookings.BookingsBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.Date;
import java.util.List;

public class CarRentalsPage extends BookingsBasePage {

    @FindBy(xpath = "//span[@class = 'bui-tab__text'][contains( text(), 'Car rentals')]")
    WebElement carRentalTab;

    @FindBy(id = "ss_origin")
    WebElement inputTextBox_searchBox;

    @FindBy(id = "")
    WebElement checkInDate;

    @FindBy(xpath = "//span[@class = 'search_hl_name']")
    List<WebElement> searchSuggestionList;



    @FindBy(id = "")
    WebElement checkOutDate;

    @FindBy(id = "")
    WebElement datesSelctionBox;

    @FindBy(xpath = "//span[contains(text() , 'Search')]")
    WebElement searchButton;

    @Override
    public ExpectedCondition<WebElement> getPageloadCondition() {
        return ExpectedConditions.elementToBeClickable(this.carRentalTab);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

    public void searchQuery(String query) {
        this.inputTextBox_searchBox.sendKeys(query);
    }

    public void clickFirstSearchSuggestions(){
        this.searchSuggestionList.get(0).click();
    }

    public void selectDates(Date date) {
        // Date input
    }

}