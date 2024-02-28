package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.amazon.AmazonPage;
import utilities.ConfigReader;
import utilities.GWD;

public class AmazonLogin {
    AmazonPage ap = new AmazonPage();

    @Given("Erdem navigates to the amazon website")
    public void erdemNavigatesToTheAmazonWebsite() {
        String title = GWD.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("amazon"));

        ap.verifyElementDisplayed(ap.mainLogoTopLeft);
    }

    @When("Erdem clicks to the sign in button and navigates to the amazon login page")
    public void erdemClicksToTheSignInButtonAndNavigatesToTheAmazonLoginPage() {
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
        ap.verifyContainsTextFunction(ap.authErrorMessage, "E-posta adresinizi veya cep telefonu numaranızı girin");

        GWD.quitDriver();
    }

    @And("Erdem trying to login with valid username and password")
    public void erdemTryingToLoginWithValidUsernameAndPassword() {
        ap.sendKeysFunction(ap.inputEmail, ConfigReader.getProperty("validEmailAmazon"));
        ap.clickFunction(ap.continueBtn);

        ap.sendKeysFunction(ap.inputPassword, ConfigReader.getProperty("validPasswordAmazon"));
        ap.clickFunction(ap.signInSubmitBtn);

    }

    @Then("Erdem should login to the amazon site successfuly")
    public void erdemShouldLoginToTheAmazonSiteSuccessfuly() {
        ap.verifyElementDisplayed(ap.mainLogoTopLeft);
        GWD.quitDriver();
    }

    @And("Erdem trying to login without entering password")
    public void erdemTryingToLoginWithoutEnteringPassword() {
        ap.sendKeysFunction(ap.inputEmail, ConfigReader.getProperty("validEmailAmazon"));
        ap.clickFunction(ap.continueBtn);

        ap.clickFunction(ap.signInSubmitBtn);
    }

    @Then("Erdem should recieve please input password error message")
    public void erdemShouldRecievePleaseInputPasswordErrorMessage() {
        ap.verifyContainsTextFunction(ap.passwordMissingAlert, "Şifrenizi girin");
    }

    @And("Erdem trying to login with valid email but invalid password")
    public void erdemTryingToLoginWithValidEmailButInvalidPassword() {
        ap.sendKeysFunction(ap.inputEmail, ConfigReader.getProperty("validEmailAmazon"));
        ap.clickFunction(ap.continueBtn);

        ap.sendKeysFunction(ap.inputPassword, ConfigReader.getProperty("invalidPasswordAmazon"));
        ap.clickFunction(ap.signInSubmitBtn);

    }

    @Then("Erdem should recieve wrong password message")
    public void erdemShouldRecieveWrongPasswordMessage() {
        ap.verifyContainsTextFunction(ap.authErrorMessage2, "Şifreniz yanlış");
    }
}
