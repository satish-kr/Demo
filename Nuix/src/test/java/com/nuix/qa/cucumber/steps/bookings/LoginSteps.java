package com.nuix.qa.cucumber.steps.bookings;

import com.nuix.qa.cucumber.steps.NuixBaseSteps;
import com.nuix.qa.pages.bookings.BookingsBasePage;
import com.nuix.qa.pages.bookings.login.SignIn_EmailPage;
import com.nuix.qa.pages.bookings.login.SignIn_PasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps extends NuixBaseSteps {
    @Given("I am on the Bookings {} Page")
    public void goToPage(String pageIdName) {
        // for demo putting url here, should come frm env prop files or jenkins piple line etc
        log.info("Loading Bookig.com homepage");
        openPageWithWait(SignIn_EmailPage.class, "http://www.booking.com");
        getWithWait(BookingsBasePage.class).navigateTo(pageIdName);
    }
    


    @And("I input password {} and click on continue button")
    public void iInputPasswordIClickOnButton(String password) {
        getWithWait(SignIn_PasswordPage.class).inputPassword(password);
        getWithWait(SignIn_PasswordPage.class).clickSignIn();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        // validate sign in, skipping for demo
    }

    @Then("I input email address {} and click on continue with email")
    public void iInputEmailAddressUser_nameAndClickOnContinueWithEmail(String email) {
        getWithWait(SignIn_EmailPage.class).inputEmail(email);
        getWithWait(SignIn_EmailPage.class).clickContinueWithEmail();
    }
}
