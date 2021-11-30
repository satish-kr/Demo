package com.nuix.qa.pages.bookings.login;

import com.nuix.qa.pages.NuixBasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

@Slf4j
public class SignIn_PasswordPage extends NuixBasePage {

    @FindBy(xpath = "//h1[@class = 'bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header']")
    private WebElement lblTitle;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement inputText_password;

    @FindBy(xpath = "//span[@class = '_1DYeoLTBFL3S4-b0JE_GoR _3hO12_mL-ixNGax_nPmmIk _1cnGB7zUOL_yH3V6Bs4i9e']")
    private WebElement showPassword;

    @FindBy(xpath = "//span[@class = '_1jp30RWusTBQoML9GSCZ_C'][contains(text(),'Sign in')]")
    private List<WebElement> button_SignIn;

    @Override
    public ExpectedCondition getPageloadCondition() {
        return ExpectedConditions.visibilityOf(this.lblTitle);
    }

    public void inputPassword(String password) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.inputText_password.sendKeys(password);
        log.info("Enterd password");

    }

    public void clickSignIn() {
        this.button_SignIn.get(0).click();
    }

}
