package pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Parent;
import utilities.GWD;

public class AmazonPage extends Parent {

    public AmazonPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()=\"Reddet\"]")
    public WebElement rejectCookiesBtn;

    @FindBy(id = "nav-link-accountList")
    public WebElement loginContainer;

    @FindBy(linkText = "Üye olun.")
    public WebElement registerInContainer;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchBtn;

    @FindBy(id = "nav-logo-sprites")
    public WebElement mainLogoTopLeft;

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
}
