package com.nuix.qa.pages.bookings.login;

import io.cucumber.java.de.Wenn;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import com.nuix.qa.pages.bookings.BookingsBasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class SignIn_EmailPage extends BookingsBasePage {

    @FindBy(xpath = "//h1[@class = 'bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header']")
    private WebElement lblTitle;

    @FindBy(id = "username")
    private WebElement InputText_EmailTextBox;

    @FindBy(xpath = "//span[@class = '_1jp30RWusTBQoML9GSCZ_C'][contains(text(),'Continue')]")
    private WebElement Button_continueWithEmail;

    @Override
    public ExpectedCondition getPageloadCondition() {
        return ExpectedConditions.visibilityOf(this.lblTitle);
    }

    public void inputEmail(String email) {
        this.InputText_EmailTextBox.sendKeys(email);
    }

    public void clickContinueWithEmail(){
        this.Button_continueWithEmail.click();
    }
}
