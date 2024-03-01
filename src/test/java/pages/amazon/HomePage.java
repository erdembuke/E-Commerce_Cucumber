package pages.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Parent;
import utilities.GWD;

public class HomePage extends Parent {

    public HomePage() {
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

}
