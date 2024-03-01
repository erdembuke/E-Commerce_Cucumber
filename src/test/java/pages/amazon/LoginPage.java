package pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Parent;
import utilities.ConfigReader;
import utilities.GWD;

public class LoginPage extends Parent {

    public LoginPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id = "ap_email")
    public WebElement inputEmail;

    @FindBy(id = "ap_password")
    public WebElement inputPassword;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitBtn;

    @FindBy(id = "auth-email-missing-alert")
    public WebElement emailMissingAlert;

    @FindBy(id = "auth-password-missing-alert")
    public WebElement passwordMissingAlert;

    @FindBy(css = "#auth-email-missing-alert .a-alert-content")
    public WebElement authErrorMessage;

    @FindBy(className = "a-alert-content")
    public WebElement authErrorMessage2;


    public void loginFunction(String email, String password) {
        sendKeysFunction(inputEmail, email);
        clickFunction(continueBtn);

        sendKeysFunction(inputPassword, password);
        clickFunction(signInSubmitBtn);
    }
}
