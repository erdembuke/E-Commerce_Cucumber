package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.amazon.HomePage;
import pages.amazon.LoginPage;
import utilities.ConfigReader;
import utilities.GWD;

public class AmazonLogin {
    HomePage hp = new HomePage();
    LoginPage ap = new LoginPage();

    @Given("Erdem navigates to the amazon website")
    public void erdemNavigatesToTheAmazonWebsite() {
        String title = GWD.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("amazon"));

        ap.verifyElementDisplayed(hp.mainLogoTopLeft);
    }

    @When("Erdem clicks to the sign in button and navigates to the amazon login page")
    public void erdemClicksToTheSignInButtonAndNavigatesToTheAmazonLoginPage() {
        ap.clickFunction(hp.loginContainer);
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
        ap.loginFunction(ConfigReader.getProperty("validEmailAmazon"), ConfigReader.getProperty("validPasswordAmazon"));

    }

    @Then("Erdem should login to the amazon site successfuly")
    public void erdemShouldLoginToTheAmazonSiteSuccessfuly() {
        ap.verifyElementDisplayed(hp.mainLogoTopLeft);
        GWD.quitDriver();
    }

    @And("Erdem trying to login without entering password")
    public void erdemTryingToLoginWithoutEnteringPassword() {
        ap.loginFunction(ConfigReader.getProperty("validEmailAmazon"),"");
    }

    @Then("Erdem should recieve please input password error message")
    public void erdemShouldRecievePleaseInputPasswordErrorMessage() {
        ap.verifyContainsTextFunction(ap.passwordMissingAlert, "Şifrenizi girin");
    }

    @And("Erdem trying to login with valid email but invalid password")
    public void erdemTryingToLoginWithValidEmailButInvalidPassword() {
        ap.loginFunction(ConfigReader.getProperty("validEmailAmazon"), ConfigReader.getProperty("invalidPasswordAmazon"));

    }

    @Then("Erdem should recieve wrong password message")
    public void erdemShouldRecieveWrongPasswordMessage() {
        ap.verifyContainsTextFunction(ap.authErrorMessage2, "Şifreniz yanlış");
    }
}
