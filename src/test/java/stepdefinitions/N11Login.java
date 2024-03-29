package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.n11.N11Page;
import utilities.ConfigReader;
import utilities.GWD;

public class N11Login {
    N11Page np = new N11Page();

    @Given("Erdem navigates to the website")
    public void erdemNavigatesToTheWebsite() {
        GWD.getDriver().get(ConfigReader.getProperty("urlN11"));

        // Assertion
        String mainPageTitle = GWD.getDriver().getTitle().toLowerCase();
        Assert.assertTrue(mainPageTitle.contains("n11"));

    }

    @And("Erdem clicks to the sign in button and sees the login page")
    public void erdemClickToTheSignInButtonAndSeesTheLoginPage() {
        np.clickFunction(np.navLoginBtn);

        // Assertion
        String loginPageTitle = GWD.getDriver().getTitle().toLowerCase();
        Assert.assertTrue(loginPageTitle.contains("giriş yap"));

    }

    @When("Erdem fills the inputs with invalid credentials and clicks login")
    public void erdemFillTheInputsWithInvalidCredentials() {
        np.sendKeysFunction(np.inputEmail, ConfigReader.getProperty("invalidEmailN11"));
        np.sendKeysFunction(np.inputPassword, ConfigReader.getProperty("invalidPasswordN11"));
        np.clickFunction(np.loginBtn);

    }

    @Then("Erdem should see the error message")
    public void erdemShouldSeeTheErrorMessage() {
        np.verifyContainsTextFunction(np.errorDiv, "E-posta adresi veya şifre hatalı");
    }

    @When("Erdem fills the inputs with valid credentials and clicks login")
    public void erdemFillsTheInputsWithValidCredentialsAndClicksLogin() {
        np.sendKeysFunction(np.inputEmail, ConfigReader.getProperty("validEmailN11"));
        np.sendKeysFunction(np.inputPassword, ConfigReader.getProperty("validPasswordN11"));
        np.clickFunction(np.loginBtn);
    }

    @Then("Erdem should login successfully")
    public void erdemShouldLoginSuccessfully() {
        np.verifyElementDisplayed(np.navUserAccountImg);
    }
}
