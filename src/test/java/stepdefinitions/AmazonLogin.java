package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.GWD;

public class AmazonLogin {
    AmazonPage ap = new AmazonPage();

    @Given("Erdem navigates to the amazon website")
    public void erdemNavigatesToTheAmazonWebsite() {
        GWD.getDriver().get(ConfigReader.getProperty("urlAmazon"));

        String title = GWD.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("amazon"));

        ap.verifyElementDisplayed(ap.mainLogoTopLeft);
    }

    @When("Erdem clicks to the sign in button and navigates to the login page")
    public void erdemClicksToTheSignInButtonAndNavigatesToTheLoginPage() {
        ap.clickFunction(ap.loginContainer);
        ap.waitUntilVisible(ap.inputEmail);
        String title = GWD.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("giriş yap"));
    }

    @And("Erdem trying to login without entering email")
    public void erdemTryingToLoginWithoutEnteringEmail() {
        ap.clickFunction(ap.continueBtn);
    }

    @Then("Erdem should recieve the email missing error message")
    public void erdemShouldRecieveTheEmailMissingErrorMessage() {
        ap.verifyContainsTextFunction(ap.authErrorMessage, "e-posta adresinizi veya cep telefonu numaranızı girin");

        GWD.quitDriver();
    }
}
